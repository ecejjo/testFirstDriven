package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile {

	private final int number;

	private int numberOfFaceUpCards;
	
	private Stack<Card> cardsStack;

	public Pile(int number, Stack<Card> cardsStack) {
		this.number = number;
		this.numberOfFaceUpCards = 0;
		this.cardsStack = cardsStack;
		this.flipFirstCard();
	}

	public void push(Card card) {
		assert this.fitsIn(card);
		this.cardsStack.push(card);
		this.numberOfFaceUpCards++;
	}

	public Card pop() {
		Card card = this.cardsStack.pop();
		this.numberOfFaceUpCards--;
		if (this.numberOfFaceUpCards == 0 && !this.cardsStack.empty()) {
			flipFirstCard();
		}
		return card;
	}

	private void flipFirstCard() {
		assert ! this.cardsStack.empty();
		assert this.numberOfFaceUpCards == 0;
		assert ! this.cardsStack.peek().isFacedUp();
		this.cardsStack.peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		if (	this.cardsStack.empty() &&
				card.getNumber() == Number.KING) {
			return true;
		}
		if ( ! this.cardsStack.empty() &&
				this.cardsStack.peek().isNextTo(card) &&
				this.cardsStack.peek().getColor() != card.getColor()) {
					return true;
		}
		return false;
	}

	public List<Card> getTop(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		int fromIndex = this.cardsStack.size() - numberOfCards;
		int toIndex = this.cardsStack.size();
		return new ArrayList<Card>(this.cardsStack.subList(fromIndex, toIndex));
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public boolean empty() {
		return this.cardsStack.empty();
	}

	public Stack<Card> getCards() {
		return this.cardsStack;
	}

	public int getNumber() {
		return this.number;
	}

	public Card peek() {
		return this.cardsStack.peek();
	}
}
