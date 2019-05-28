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
		this.numberOfFaceUpCards--;
		return this.cardsStack.pop();
	}

	private void flipFirstCard() {
		assert !this.getCards().empty() && this.numberOfFaceUpCards == 0 && !this.getCards().peek().isFacedUp();
		this.getCards().peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		return (this.getCards().empty() && card.getNumber() == Number.KING) || (!this.getCards().empty()
				&& this.getCards().peek().isNextTo(card) && this.getCards().peek().getColor() != card.getColor());
	}

	public List<Card> getTop(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		return new ArrayList<Card>(this.getCards().subList(this.getCards().size() - numberOfCards, this.getCards().size()));
	}

	public void removeTop(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		for (int i = 0; i < numberOfCards; i++) {
			this.getCards().pop();
			numberOfFaceUpCards--;
		}
		if (this.numberOfFaceUpCards == 0 && !this.getCards().empty()) {
			flipFirstCard();
		}
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public boolean empty() {
		return this.getCards().empty();
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
