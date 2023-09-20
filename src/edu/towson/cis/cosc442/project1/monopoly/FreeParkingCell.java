package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class FreeParkingCell.
 */
public class FreeParkingCell extends Cell {

	/** The available. */
	private boolean available = true;

	/**
	 * Instantiates a new free parking cell.
	 */
	public FreeParkingCell() {
		setName("Free Parking");
	}

	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public boolean playAction(String msg) {
		return false;
	}
}
