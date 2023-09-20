package edu.towson.cis.cosc442.project1.monopoly;


// TODO: Auto-generated Javadoc
/**
 * The Class MovePlayerCard.
 */
public class MovePlayerCard extends Card {
    
    /** The destination. */
    private String destination;
    
    /** The type. */
    private int type;

    /**
     * Instantiates a new move player card.
     *
     * @param destination the destination
     * @param cardType the card type
     */
    public MovePlayerCard(String destination, int cardType) {
        this.destination = destination;
        this.type = cardType;
    }

    /**
     * Apply action.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        IOwnable currentPosition = currentPlayer.getPosition();
        int newCell = GameMaster.instance().getGameBoard().queryCellIndex(destination);
        int currentCell = GameMaster.instance().getGameBoard().queryCellIndex(currentPosition.getName());
        int diceValue = 0;
        if(currentCell > newCell) {
            diceValue = (GameMaster.instance().getGameBoard().getCellNumber() + 
                    (newCell - currentCell));
        }
        else if(currentCell <= newCell) {
            diceValue = newCell - currentCell;
        }
        System.out.println(diceValue);
        GameMaster.instance().movePlayer(currentPlayer, diceValue);
    }

    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public int getCardType() {
        return type;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return "Go to " + destination;
    }

}
