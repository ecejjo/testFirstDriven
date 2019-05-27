package klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Stock {

	private Stack<Card> cardsStack;
	
    public Stock() {
    	this.cardsStack = new Stack<Card>(); 
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cardsStack.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cardsStack);
    }

    public List<Card> takeTop(int quantity) {
        assert 0 < quantity && quantity <= this.cardsStack.size();
        List<Card> cardsToReturn = new ArrayList<Card>(this.cardsStack.subList(0, quantity));
        this.cardsStack.removeAll(cardsToReturn);
        return cardsToReturn;
    }

	public boolean empty() {
		return this.cardsStack.empty();
	}

	public Card peek() {
		return this.cardsStack.peek();
	}

	public Card pop() {
		return this.cardsStack.pop();
	}

	public void push(Card card) {
		this.cardsStack.push(card);
	}
}
