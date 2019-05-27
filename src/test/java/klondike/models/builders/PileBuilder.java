package klondike.models.builders;

import java.util.Stack;

import klondike.models.Card;
import klondike.models.Pile;

public class PileBuilder {

	private Stack<Card> cardsStack;
	
	public PileBuilder() {
		this.cardsStack = new Stack<Card>();
	}
	
	public PileBuilder card(Card card) {
		this.cardsStack.push(card);
		return this;
	}
	
	public PileBuilder card() {
		this.cardsStack.push(new CardBuilder().build());
		return this;
	}
	
	public Pile build() {
		if (this.cardsStack.empty()) {
			this.cardsStack.push(new CardBuilder().build());
			Pile pile = new Pile(0, this.cardsStack);
			pile.pop();
			return pile;
		}
		return new Pile(0, this.cardsStack);
	}
}
