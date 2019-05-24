package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock {

	private CardStack cardStack;
	
    public Stock() {
        cardStack = new CardStack(); 
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cardStack.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cardStack.cards);
    }

    public List<Card> takeTop(int quantity) {
        assert 0 < quantity && quantity <= this.cardStack.cards.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cardStack.cards.subList(0, quantity));
        this.cardStack.cards.removeAll(cardsToReturn);
        return cardsToReturn;
    }

	public boolean empty() {
		return this.cardStack.empty();
	}

	public Card peek() {
		return this.cardStack.peek();
	}

	public Card pop() {
		return this.cardStack.pop();
	}

	public void push(Card card) {
		this.cardStack.push(card);
	}

}
