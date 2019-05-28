package klondike.models;

import java.util.Collections;
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

    public Stack<Card> pop(int quantity) {
        assert quantity > 0;
        assert quantity <= this.cardsStack.size();
        
        Stack<Card> cardsToReturn = new Stack<Card>();
        for (int i = 0; i < quantity; i++) {
			cardsToReturn.push(this.cardsStack.pop());
		}
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
