package edu.towson.cis.cosc442.project1.monopoly;


// TODO: Auto-generated Javadoc
/**
 * The Class JailCard.
 */
public class JailCard extends Card {
    
    /** The type. */
    int type;
    
    /**
     * Instantiates a new jail card.
     *
     * @param cardType the card type
     */
    public JailCard(int cardType) {
        type = cardType;
    }

    /**
     * Apply action.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
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
        return "Go to Jail immediately without collecting" +
        		" $200 when passing the GO cell";
    }
}
