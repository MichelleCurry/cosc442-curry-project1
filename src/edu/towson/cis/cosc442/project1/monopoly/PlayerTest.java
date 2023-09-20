package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest extends TestCase {

	/** The game master. */
	GameMaster gameMaster;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	protected void setUp() throws Exception {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new SimpleGameBoard());
        gameMaster.setGUI(new MockGUI());
        gameMaster.setTestMode(true);
        gameMaster.reset();
	}
	
	/**
	 * Test purchase property.
	 */
	public void testPurchaseProperty() {
		gameMaster.setNumberOfPlayers(1);
		gameMaster.movePlayer(0, 3);
		Player player = gameMaster.getPlayer(0);
		player.purchase();
		assertEquals(1380, player.getMoney());
		assertEquals("Blue 3", player.getProperty(0).getName());
		PropertyCell cell =
			(PropertyCell) gameMaster.getGameBoard().queryCell("Blue 3");
		assertSame(player, cell.getOwner());
	}

	/**
	 * Test same go cell.
	 */
	public void testSameGoCell() {
		GameBoard gameboard = gameMaster.getGameBoard();
		Player player1 = new Player();
		Player player2 = new Player();
		IOwnable go = gameboard.queryCell("Go");
		assertSame(go, player1.getPosition());
		assertSame(go, player2.getPosition());
	}
	
	/**
	 * Test pay rent to.
	 */
	public void testPayRentTo() {
		gameMaster.setNumberOfPlayers(2);
		gameMaster.movePlayer(0,4);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.movePlayer(1,4);
		gameMaster.btnEndTurnClicked();
		assertTrue(gameMaster.getPlayer(1).isBankrupt());
		assertEquals(2800, gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test exchange property.
	 */
	public void testExchangeProperty() {
		gameMaster.setNumberOfPlayers(2);
		gameMaster.movePlayer(0,3);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.getPlayer(0).exchangeProperty(gameMaster.getPlayer(1));
		assertEquals(1,gameMaster.getCurrentPlayer().getPropertyNumber());
	}
	
	/**
	 * Test purchase house.
	 */
	public void testPurchaseHouse() {
		gameMaster.setNumberOfPlayers(1);
		gameMaster.startGame();
		gameMaster.movePlayer(gameMaster.getCurrentPlayerIndex(),1);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.movePlayer(0,1);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.movePlayer(0,1);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.getCurrentPlayer().purchaseHouse("blue",2);
		assertEquals("blue", gameMaster.getCurrentPlayer().getMonopolies()[0]);
		assertEquals(880, gameMaster.getCurrentPlayer().getMoney());
	}
	
	/**
	 * Test reset property.
	 */
	public void testResetProperty() {
		gameMaster.setNumberOfPlayers(1);
		gameMaster.movePlayer(0,1);
		gameMaster.getCurrentPlayer().purchase();
		assertEquals(gameMaster.getGameBoard().getCell(1), gameMaster.getCurrentPlayer().getAllProperties()[0]);
		gameMaster.getCurrentPlayer().resetProperty();
		assertEquals(0,gameMaster.getCurrentPlayer().getAllProperties().length);
	}
}
