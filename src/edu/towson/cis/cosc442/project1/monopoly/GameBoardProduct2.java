package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class GameBoardProduct2.
 */
public class GameBoardProduct2 {
	
	/** The chance cards. */
	private ArrayList<Card> chanceCards = new ArrayList<Card>();

	/**
	 * Draw chance card.
	 *
	 * @param thisCommunityChestCards the this community chest cards
	 * @return the card
	 */
	public Card drawChanceCard(ArrayList<Card> thisCommunityChestCards) {
		Card card = (Card) chanceCards.get(0);
		chanceCards.remove(0);
		addCard(card, thisCommunityChestCards);
		return card;
	}

	/**
	 * Adds the card.
	 *
	 * @param card the card
	 * @param thisCommunityChestCards the this community chest cards
	 */
	public void addCard(Card card, ArrayList<Card> thisCommunityChestCards) {
		if (card.getCardType() == Card.TYPE_CC) {
			thisCommunityChestCards.add(card);
		} else {
			chanceCards.add(card);
		}
	}
}