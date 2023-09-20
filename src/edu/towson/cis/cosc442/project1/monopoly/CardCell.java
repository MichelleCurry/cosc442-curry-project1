package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class CardCell.
 */
public class CardCell extends Cell {
    
    /** The type. */
    private int type;
	
	/**
	 * Instantiates a new card cell.
	 *
	 * @param type the type
	 * @param name the name
	 */
	public CardCell(int type, String name) {
        setName(name);
        this.type = type;
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
    
    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

	/**
	 * Player moved.
	 *
	 * @param player the player
	 * @param playerIndex the player index
	 * @param gameMaster the game master
	 */
	public void playerMoved(Player player, int playerIndex, GameMaster gameMaster) {
		gameMaster.getGUI().setDrawCardEnabled(true);
	}
}
