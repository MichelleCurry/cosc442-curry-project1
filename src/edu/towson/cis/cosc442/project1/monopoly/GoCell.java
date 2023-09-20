package edu.towson.cis.cosc442.project1.monopoly;

public class GoCell extends Cell {
	private boolean available = true;

	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	public boolean playAction(String msg) {
		return false;
	}
	
	void setName(String name) {
	}
}
