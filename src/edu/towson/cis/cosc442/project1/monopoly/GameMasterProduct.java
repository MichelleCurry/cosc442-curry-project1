package edu.towson.cis.cosc442.project1.monopoly;


public class GameMasterProduct {
	private Die[] dice;
	private boolean testMode;

	public void setDice(Die[] dice) {
		this.dice = dice;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

	public int[] rollDice(MonopolyGUI thisGui) {
		if (testMode) {
			return thisGui.getDiceRoll();
		} else {
			return new int[] { dice[0].getRoll(), dice[1].getRoll() };
		}
	}
}