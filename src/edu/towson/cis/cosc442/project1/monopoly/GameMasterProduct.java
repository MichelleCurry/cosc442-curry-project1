package edu.towson.cis.cosc442.project1.monopoly;


// TODO: Auto-generated Javadoc
/**
 * The Class GameMasterProduct.
 */
public class GameMasterProduct {
	
	/** The dice. */
	private Die[] dice;
	
	/** The test mode. */
	private boolean testMode;

	/**
	 * Sets the dice.
	 *
	 * @param dice the new dice
	 */
	public void setDice(Die[] dice) {
		this.dice = dice;
	}

	/**
	 * Sets the test mode.
	 *
	 * @param testMode the new test mode
	 */
	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

	/**
	 * Roll dice.
	 *
	 * @param thisGui the this gui
	 * @return the int[]
	 */
	public int[] rollDice(MonopolyGUI thisGui) {
		if (testMode) {
			return thisGui.getDiceRoll();
		} else {
			return new int[] { dice[0].getRoll(), dice[1].getRoll() };
		}
	}
}