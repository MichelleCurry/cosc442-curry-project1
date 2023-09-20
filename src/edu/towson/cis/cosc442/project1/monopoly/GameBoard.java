package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameBoard.
 */
public class GameBoard {

	/** The game board product 2. */
	private GameBoardProduct2 gameBoardProduct2 = new GameBoardProduct2();
	
	/** The game board product. */
	private GameBoardProduct gameBoardProduct = new GameBoardProduct();
	
	/** The community chest cards. */
	private ArrayList<Card> communityChestCards = new ArrayList<Card>();
	
	/**
	 * Instantiates a new game board.
	 */
	public GameBoard() {
		Cell go = new GoCell();
		addCell(go);
	}

    /**
     * Adds the card.
     *
     * @param card the card
     */
    public void addCard(Card card) {
        gameBoardProduct2.addCard(card, this.communityChestCards);
    }
	
	/**
	 * Adds the cell.
	 *
	 * @param cell the cell
	 */
	public void addCell(Cell cell) {
		gameBoardProduct.getCells().add(cell);
	}
	
	/**
	 * Adds the cell.
	 *
	 * @param cell the cell
	 */
	public void addCell(PropertyCell cell) {
		gameBoardProduct.addCell(cell);
	}

    /**
     * Draw CC card.
     *
     * @return the card
     */
    public Card drawCCCard() {
        Card card = (Card)communityChestCards.get(0);
        communityChestCards.remove(0);
        gameBoardProduct2.addCard(card, this.communityChestCards);
        return card;
    }

    /**
     * Draw chance card.
     *
     * @return the card
     */
    public Card drawChanceCard() {
        return gameBoardProduct2.drawChanceCard(this.communityChestCards);
    }

	/**
	 * Gets the cell.
	 *
	 * @param newIndex the new index
	 * @return the cell
	 */
	public Cell getCell(int newIndex) {
		return gameBoardProduct.getCell(newIndex);
	}
	
	/**
	 * Gets the cell number.
	 *
	 * @return the cell number
	 */
	public int getCellNumber() {
		return gameBoardProduct.getCellNumber();
	}
	
	/**
	 * Gets the properties in monopoly.
	 *
	 * @param color the color
	 * @return the properties in monopoly
	 */
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		return gameBoardProduct.getPropertiesInMonopoly(color);
	}
	
	/**
	 * Gets the property number for color.
	 *
	 * @param name the name
	 * @return the property number for color
	 */
	public int getPropertyNumberForColor(String name) {
		return gameBoardProduct.getPropertyNumberForColor(name);
	}

	/**
	 * Query cell.
	 *
	 * @param string the string
	 * @return the cell
	 */
	public Cell queryCell(String string) {
		return gameBoardProduct.queryCell(string);
	}
	
	/**
	 * Query cell index.
	 *
	 * @param string the string
	 * @return the int
	 */
	public int queryCellIndex(String string){
		return gameBoardProduct.queryCellIndex(string);
	}

    /**
     * Removes the cards.
     */
    public void removeCards() {
        communityChestCards.clear();
    }
}
