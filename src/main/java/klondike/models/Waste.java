package klondike.models;

import java.util.Stack;

public class Waste {
	
	private Stack<Card> cardsStack;
	
    public Waste() {
        this.cardsStack = new Stack<Card>();
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
