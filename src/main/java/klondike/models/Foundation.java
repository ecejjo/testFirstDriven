package klondike.models;

import java.util.Stack;

public class Foundation {

    private Suit suit;
    private Stack<Card> cardsStack;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
        this.cardsStack = new Stack<Card>(); 
    }

    public boolean isComplete() {
        return this.cardsStack.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return card.getSuit() == this.suit &&
                (card.getNumber() == Number.AS ||
                        (!this.empty() && card.isNextTo(this.peek())));
    }

    public Suit getSuit() {
        return this.suit;
    }

	public void push(Card card) {
		this.cardsStack.push(card);
	}

	public Card peek() {
		return this.cardsStack.peek();
	}

	public boolean empty() {
		return this.cardsStack.empty();
	}

	public Card pop() {
		return this.cardsStack.pop();
	}
}
