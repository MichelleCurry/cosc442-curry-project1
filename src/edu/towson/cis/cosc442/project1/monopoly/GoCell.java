package edu.towson.cis.cosc442.project1.monopoly;

public class GoCell extends Cell {
	private boolean available = true;

	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	public void playAction() {
	}
	
	void setName(String name) {
	}
}
