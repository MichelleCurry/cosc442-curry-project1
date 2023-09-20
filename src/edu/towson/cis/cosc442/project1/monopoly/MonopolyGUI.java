package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Interface MonopolyGUI.
 */
public interface MonopolyGUI {
	
	/**
	 * Enable end turn btn.
	 *
	 * @param playerIndex the player index
	 */
	public void enableEndTurnBtn(int playerIndex);
	
	/**
	 * Enable player turn.
	 *
	 * @param playerIndex the player index
	 */
	public void enablePlayerTurn(int playerIndex);
	
	/**
	 * Enable purchase btn.
	 *
	 * @param playerIndex the player index
	 */
	public void enablePurchaseBtn(int playerIndex);
	
	/**
	 * Gets the dice roll.
	 *
	 * @return the dice roll
	 */
	public int[] getDiceRoll();
    
    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled();
    
    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled();
	
	/**
	 * Checks if is gets the out of jail button enabled.
	 *
	 * @return true, if is gets the out of jail button enabled
	 */
	public boolean isGetOutOfJailButtonEnabled();
    
    /**
     * Checks if is trade button enabled.
     *
     * @param i the i
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled(int i);
	
	/**
	 * Move player.
	 *
	 * @param index the index
	 * @param from the from
	 * @param to the to
	 */
	public void movePlayer(int index, int from, int to);
    
    /**
     * Open respond dialog.
     *
     * @param deal the deal
     * @return the respond dialog
     */
    public RespondDialog openRespondDialog(TradeDeal deal);
    
    /**
     * Open trade dialog.
     *
     * @return the trade dialog
     */
    public TradeDialog openTradeDialog();
    
    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b);
    
    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b);
    
    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled);
    
    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b);
    
    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled);
    
    /**
     * Sets the roll dice enabled.
     *
     * @param b the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean b);
    
    /**
     * Sets the trade enabled.
     *
     * @param index the index
     * @param b the b
     */
    public void setTradeEnabled(int index, boolean b);
    
    /**
     * Show buy house dialog.
     *
     * @param currentPlayer the current player
     */
    public void showBuyHouseDialog(Player currentPlayer);
    
    /**
     * Show message.
     *
     * @param string the string
     */
    public void showMessage(String string);
	
	/**
	 * Show util dice roll.
	 *
	 * @return the int
	 */
	public int showUtilDiceRoll();
	
	/**
	 * Start game.
	 */
	public void startGame();
	
	/**
	 * Update.
	 */
	public void update();
}
