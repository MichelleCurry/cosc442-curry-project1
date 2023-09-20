package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilityCell.
 */
public class UtilityCell extends Cell {

	/** The Constant COLOR_GROUP. */
	public static final String COLOR_GROUP = "UTILITY";
	
	/** The price. */
	private static int PRICE;

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public static void setPrice(int price) {
		UtilityCell.PRICE = price;
	}

	/** The available. */
	private boolean available = true;

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return UtilityCell.PRICE;
	}

	/**
	 * Gets the rent.
	 *
	 * @param diceRoll the dice roll
	 * @return the rent
	 */
	public int getRent(int diceRoll) {
		if(theOwner.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (theOwner.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public boolean playAction(String msg) {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				GameMaster.instance().utilRollDice();
				int diceRoll = GameMaster.instance().getUtilDiceRoll();
				currentPlayer.payRentTo(theOwner, getRent(diceRoll));
			}
		}
		return false;
	}
}
