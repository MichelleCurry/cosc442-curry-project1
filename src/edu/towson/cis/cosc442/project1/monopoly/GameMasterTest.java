package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class GameMasterTest.
 */
public class GameMasterTest extends TestCase {

	/** The game master. */
	GameMaster gameMaster;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	protected void setUp() throws Exception {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardFull());
		gameMaster.setNumberOfPlayers(2);
        gameMaster.getPlayer(0).setName("Player 1");
        gameMaster.getPlayer(1).setName("Player 2");
		gameMaster.reset();
		gameMaster.setTestMode(true);
        gameMaster.setGUI(new MockGUI());
        gameMaster.startGame();
	}
	
	/**
	 * Test init.
	 */
	public void testInit() {
		assertEquals(gameMaster.getInitAmountOfMoney(),
				gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test reset.
	 */
	public void testReset() {
		gameMaster.movePlayer(0, 3);
		gameMaster.movePlayer(1, 4);
		gameMaster.reset();
		for(int i = 0; i < gameMaster.getNumberOfPlayers(); i++) {
			Player player = gameMaster.getPlayer(i);
			assertEquals("Go", player.getPosition().getName());
		}
		assertEquals(0, gameMaster.getTurn());
	}
    
    /**
     * Test trade process.
     */
    public void testTradeProcess() {
        MonopolyGUI gui = gameMaster.getGUI();
        assertTrue(gui.isTradeButtonEnabled(0));
        assertFalse(gui.isTradeButtonEnabled(1));
        gameMaster.movePlayer(0, 1);
        assertFalse(gui.isTradeButtonEnabled(0));
        assertFalse(gui.isTradeButtonEnabled(1));
        gameMaster.getCurrentPlayer().purchase();
        assertEquals(gameMaster.getGameBoard().getCell(1),gameMaster.getCurrentPlayer().getAllProperties()[0]);
        gameMaster.btnEndTurnClicked();
        TradeDialog dialog = gui.openTradeDialog();
        assertEquals(1, gameMaster.getNumberOfSellers());
        ArrayList<?> sellerList = gameMaster.getSellerList();
        assertEquals(gameMaster.getPlayer(0), sellerList.get(0));
        TradeDeal deal = dialog.getTradeDeal();
        RespondDialog respond = gui.openRespondDialog(deal);
        Player player1 = gameMaster.getPlayer(0);
        Player player2 = gameMaster.getPlayer(1);
        assertTrue(respond.getResponse());
        gameMaster.completeTrade(deal);
        assertEquals(1440 + deal.getAmount(), player1.getMoney());
        assertEquals(1500 - deal.getAmount(), player2.getMoney());
        assertFalse(player1.checkProperty(deal.getPropertyName()));
        assertTrue(player2.checkProperty(deal.getPropertyName()));
    }
	
	/**
	 * Test turn.
	 */
	public void testTurn() {
		assertEquals(0, gameMaster.getTurn());
		gameMaster.switchTurn();
		assertEquals(1, gameMaster.getTurn());
		gameMaster.switchTurn();
		assertEquals(0, gameMaster.getTurn());
	}
	
	/**
	 * Test button get out of jail clicked.
	 */
	public void testButtonGetOutOfJailClicked() {
		MonopolyGUI gui = gameMaster.getGUI();
		gameMaster.movePlayer(0,30);
		gameMaster.btnEndTurnClicked();
		assertEquals("Jail", gameMaster.getPlayer(0).getPosition().getName());
		gameMaster.movePlayer(1,2);
		gameMaster.btnEndTurnClicked();
		assertTrue(gui.isGetOutOfJailButtonEnabled());
		assertTrue(gameMaster.getPlayer(0).isInJail());
		gameMaster.btnGetOutOfJailClicked();
		assertFalse(gameMaster.getPlayer(0).isInJail());
		assertEquals(1450,gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test button purchase property clicked.
	 */
	public void testButtonPurchasePropertyClicked() {
		@SuppressWarnings("unused")
		MonopolyGUI gui = gameMaster.getGUI();
		gameMaster.movePlayer(0,1);
		gameMaster.btnPurchasePropertyClicked();
		assertEquals(gameMaster.getGameBoard().getCell(1), gameMaster.getCurrentPlayer().getAllProperties()[0]);
		assertEquals(1440,gameMaster.getCurrentPlayer().getMoney());
	}
	
	/**
	 * Test button roll dice clicked.
	 */
	public void testButtonRollDiceClicked() {
		gameMaster.reset();
		gameMaster.getGUI();
		gameMaster.btnRollDiceClicked();
		assertEquals(0,gameMaster.getCurrentPlayerIndex());
		assertEquals(gameMaster.getGameBoard().getCell(5), gameMaster.getPlayer(0).getPosition());
	}
	
	/**
	 * Test button trade clicked.
	 */
	public void testButtonTradeClicked() {
		gameMaster.getGUI();
		gameMaster.movePlayer(0,1);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.btnTradeClicked();
		assertEquals(gameMaster.getGameBoard().getCell(1),gameMaster.getCurrentPlayer().getAllProperties()[0]);
		assertEquals(1640,gameMaster.getPlayer(0).getMoney());
		assertEquals(1300,gameMaster.getPlayer(1).getMoney());
	}
}
