package klondike.models;

public class Foundation {

    private Suit suit;
    private CardStack cardStack;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
        cardStack = new CardStack(); 
    }

    public boolean isComplete() {
        return this.cardStack.cards.size() == Number.values().length;
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
		this.cardStack.push(card);
	}

	public Card peek() {
		return this.cardStack.peek();
	}

	public boolean empty() {
		return this.cardStack.empty();
	}

	public Card pop() {
		return this.cardStack.pop();
	}
}
