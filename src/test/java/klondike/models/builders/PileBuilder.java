package klondike.models.builders;

import klondike.models.Card;
import klondike.models.CardStack;
import klondike.models.Pile;

public class PileBuilder {

	private CardStack cardStack;
	
	public PileBuilder() {
		this.cardStack = new CardStack();
	}
	
	public PileBuilder card(Card card) {
		this.cardStack.push(card);
		return this;
	}
	
	public PileBuilder card() {
		this.cardStack.push(new CardBuilder().build());
		return this;
	}
	
	public Pile build() {
		if (this.cardStack.empty()) {
			this.cardStack.push(new CardBuilder().build());
			Pile pile = new Pile(0, this.cardStack);
			pile.pop();
			return pile;
		}
		return new Pile(0, this.cardStack);
	}
}
