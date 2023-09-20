package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class MockGUI.
 */
public class MockGUI implements MonopolyGUI {
    
    /** The btn get out of jail state. */
    private boolean btnDrawCardState, btnEndTurnState, btnGetOutOfJailState;
    
    /** The btn trade state. */
    private boolean[] btnTradeState = new boolean[2];

    /**
     * Enable end turn btn.
     *
     * @param playerIndex the player index
     */
    public void enableEndTurnBtn(int playerIndex) {
    }

    /**
     * Enable player turn.
     *
     * @param playerIndex the player index
     */
    public void enablePlayerTurn(int playerIndex) {
    }

    /**
     * Enable purchase btn.
     *
     * @param playerIndex the player index
     */
    public void enablePurchaseBtn(int playerIndex) {
    }
	
	/**
	 * Gets the dice roll.
	 *
	 * @return the dice roll
	 */
	public int[] getDiceRoll() {
		int roll[] = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	/**
	 * Checks if is gets the out of jail button enabled.
	 *
	 * @return true, if is gets the out of jail button enabled
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    /**
     * Checks if is trade button enabled.
     *
     * @param i the i
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    /**
     * Move player.
     *
     * @param index the index
     * @param from the from
     * @param to the to
     */
    public void movePlayer(int index, int from, int to) {
    }

    /**
     * Open respond dialog.
     *
     * @param deal the deal
     * @return the respond dialog
     */
    public RespondDialog openRespondDialog(TradeDeal deal) {
        RespondDialog dialog = new MockRespondDialog(deal);
        return dialog;
    }

    /**
     * Open trade dialog.
     *
     * @return the trade dialog
     */
    public TradeDialog openTradeDialog() {
        TradeDialog dialog = new MockTradeDialog();
        return dialog;
    }

    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b) {
    }

    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
    }

    /**
     * Sets the roll dice enabled.
     *
     * @param b the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean b) {
    }

    /**
     * Sets the trade enabled.
     *
     * @param index the index
     * @param b the b
     */
    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    /**
     * Show buy house dialog.
     *
     * @param currentPlayer the current player
     */
    public void showBuyHouseDialog(Player currentPlayer) {
    }

    /**
     * Show message.
     *
     * @param string the string
     */
    public void showMessage(String string) {
    }

	/**
	 * Show util dice roll.
	 *
	 * @return the int
	 */
	public int showUtilDiceRoll() {
//		int[] diceValues = GameMaster.instance().rollDice();
//		return diceValues[0] + diceValues[1];
		return 10;
	}

    /**
     * Start game.
     */
    public void startGame() {
    }

	/**
	 * Update.
	 */
	public void update() {
	}
}
