package edu.towson.cis.cosc442.project1.monopoly;

public class GoToJailCell extends Cell {
	
	private boolean available = true;

	public GoToJailCell() {
		setName("Go to Jail");
	}

	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
	}
}
