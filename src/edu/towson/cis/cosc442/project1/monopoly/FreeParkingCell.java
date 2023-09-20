package edu.towson.cis.cosc442.project1.monopoly;

public class FreeParkingCell extends Cell {

	private boolean available = true;

	public FreeParkingCell() {
		setName("Free Parking");
	}

	public void playAction() {
		return;
	}
}
