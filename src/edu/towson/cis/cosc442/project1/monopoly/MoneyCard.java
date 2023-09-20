package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class MoneyCard.
 */
public class MoneyCard extends Card {
    
    /** The amount. */
    private int amount;
    
    /** The card type. */
    private int cardType;
    
    /** The label. */
    private String label;
    
    /**
     * Instantiates a new money card.
     *
     * @param label the label
     * @param amount the amount
     * @param cardType the card type
     */
    public MoneyCard(String label, int amount, int cardType){
        this.label = label;
        this.amount = amount;
        this.cardType = cardType;
    }

    /**
     * Apply action.
     */
    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		currentPlayer.setMoney(currentPlayer.getMoney() + amount);
    }

    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }
}
