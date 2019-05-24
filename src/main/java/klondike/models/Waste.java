package klondike.models;

public class Waste {
	
	CardStack cardStack;
	
    public Waste() {
        this.cardStack = new CardStack();
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
