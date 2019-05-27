package klondike.models.builders;

import java.util.ArrayList;
import java.util.List;

import klondike.models.Card;
import klondike.models.Foundation;
import klondike.models.Suit;

public class FoundationBuilder {

	private Suit suit;
	
	private List<Card> cardsList;
	
	public FoundationBuilder() {
		this.suit = Suit.CLOVERS;
		this.cardsList = new ArrayList<Card>();
	}
	
	public FoundationBuilder suit(Suit suit) {
		this.suit = suit;
		return this;
	}
	
	public FoundationBuilder card(Card card) {
		this.cardsList.add(card);
		return this;
	}
	
	public Foundation build() {
		Foundation foundation = new Foundation(this.suit);
		for(Card card: this.cardsList) {
			foundation.push(card);
		}
		return foundation;
	}
	
}
