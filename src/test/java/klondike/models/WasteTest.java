package klondike.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klondike.models.builders.CardBuilder;

public class WasteTest {

	protected Waste createWaste() {
		return new Waste();
	}

	protected List<Card> getCards(){
		List<Card> cardsList = new ArrayList<Card>();
		cardsList.add(new CardBuilder().build());
		cardsList.add(new CardBuilder().build());
		return cardsList;
	}
	
	@Test
	public void testEmptyWithEmpty() {
		Waste waste = this.createWaste();
		assertTrue(waste.empty());
	}
	
	@Test
	public void testEmptyWithNotEmpty() {
		Waste waste = this.createWaste();
		waste.push(this.getCards().get(0));
		assertFalse(waste.empty());
	}

	@Test
	public void testPushWithEmpty() {
		Waste waste = this.createWaste();
		waste.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), waste.peek());
	}
	
	@Test
	public void testPushWithNotEmpty() {
		Waste waste = this.createWaste();
		waste.push(this.getCards().get(0));
		waste.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), waste.peek());
	}

	@Test
	public void testPopEmpty() {
		Waste waste = this.createWaste();
		waste.push(this.getCards().get(0));
		assertEquals(this.getCards().get(0), waste.pop());
		assertTrue(waste.empty());
	}
	
	@Test
	public void testPopNotEmpty() {
		Waste waste = this.createWaste();
		waste.push(this.getCards().get(0));
		waste.push(this.getCards().get(1));
		assertEquals(this.getCards().get(1), waste.pop());
		assertEquals(this.getCards().get(0), waste.peek());
	}

	
}
