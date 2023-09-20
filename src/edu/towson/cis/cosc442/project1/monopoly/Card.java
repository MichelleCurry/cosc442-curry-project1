package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class Card.
 */
public abstract class Card {

    /** The type chance. */
    public static int TYPE_CHANCE = 1;
    
    /** The type cc. */
    public static int TYPE_CC = 2;

    /**
     * Gets the label.
     *
     * @return the label
     */
    public abstract String getLabel();
    
    /**
     * Apply action.
     */
    public abstract void applyAction();
    
    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public abstract int getCardType();
}
