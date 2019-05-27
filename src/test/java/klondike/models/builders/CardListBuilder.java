package klondike.models.builders;

import java.util.ArrayList;
import java.util.List;

import klondike.models.Card;

public class CardListBuilder {

	private List<Card> cardsList;
	
	public CardListBuilder() {
		this.cardsList = new ArrayList<Card>();
	}
	
	public CardListBuilder card(Card card) {
		this.cardsList.add(card);
		return this;
	}
	
	public List<Card> build(){
		return this.cardsList;
	}
	
}
