package edu.towson.cis.cosc442.project1.monopoly;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
//Task 7 junit tests
/**
 * The Class CardsTest.
 */
//Task 8 viewed test case failure
public class CardsTest extends TestCase {
    
    /** The chance card. */
    Card ccCard, chanceCard;
    
    /** The game master. */
    GameMaster gameMaster;

    /**
     * Sets the up.
     */
    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }
    
    /**
     * Test card type.
     */
    public void testCardType() {
        gameMaster.drawCCCard();
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
        gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
}
