package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;

public class GameBoardProduct2 {
	private ArrayList<Card> chanceCards = new ArrayList<Card>();

	public Card drawChanceCard(ArrayList<Card> thisCommunityChestCards) {
		Card card = (Card) chanceCards.get(0);
		chanceCards.remove(0);
		addCard(card, thisCommunityChestCards);
		return card;
	}

	public void addCard(Card card, ArrayList<Card> thisCommunityChestCards) {
		if (card.getCardType() == Card.TYPE_CC) {
			thisCommunityChestCards.add(card);
		} else {
			chanceCards.add(card);
		}
	}
}