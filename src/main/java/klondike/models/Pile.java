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
		this.faceUpFirstCard();
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

	public void faceUpFirstCard() {
		if (this.empty() ||
			this.cardsStack.peek().isFacedUp()) {
			return;
		}
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
		ArrayList<Card> arrayList = new ArrayList<Card>();
		for (int i = 0; i < numberOfCards; i++) {
			arrayList.add(0, this.pop());
			this.faceUpFirstCard();
		}
		return arrayList;
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
