package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {
	
	/** The player product. */
	private PlayerProduct playerProduct = new PlayerProduct();
	
	/** The in jail. */
	private boolean inJail;
	
	/** The money. */
	private int money;
	
	/** The name. */
	private String name;

	/** The position. */
	private IOwnable position;
	
	/** The properties. */
	private ArrayList<PropertyCell> properties = new ArrayList<PropertyCell>();
	
	/** The railroads. */
	private ArrayList<Cell> railroads = new ArrayList<Cell>();
	
	/** The utilities. */
	private ArrayList<Cell> utilities = new ArrayList<Cell>();
	
	/**
	 * Instantiates a new player.
	 */
	public Player() {
		GameBoard gb = GameMaster.instance().getGameBoard();
		inJail = false;
		if(gb != null) {
			position = gb.queryCell("Go");
		}
	}

    /**
     * Buy property.
     *
     * @param property the property
     * @param amount the amount
     */
    public void buyProperty(Cell property, int amount) {
        property.setOwner(this);
        if(property instanceof PropertyCell) {
            PropertyCell cell = (PropertyCell)property;
            properties.add(cell);
            playerProduct.getColorGroups().put(
                    cell.getColorGroup(), 
                    new Integer(playerProduct.getPropertyNumberForColor(cell.getColorGroup())+1));
        }
        if(property instanceof RailRoadCell) {
            railroads.add(property);
            playerProduct.getColorGroups().put(
                    RailRoadCell.COLOR_GROUP, 
                    new Integer(playerProduct.getPropertyNumberForColor(RailRoadCell.COLOR_GROUP)+1));
        }
        if(property instanceof UtilityCell) {
            utilities.add(property);
            playerProduct.getColorGroups().put(
                    UtilityCell.COLOR_GROUP, 
                    new Integer(playerProduct.getPropertyNumberForColor(UtilityCell.COLOR_GROUP)+1));
        }
        setMoney(getMoney() - amount);
    }
	
	/**
	 * Can buy house.
	 *
	 * @return true, if successful
	 */
	public boolean canBuyHouse() {
		return (playerProduct.getMonopolies().length != 0);
	}

	/**
	 * Check property.
	 *
	 * @param property the property
	 * @return true, if successful
	 */
	public boolean checkProperty(String property) {
		for(int i=0;i<properties.size();i++) {
			IOwnable cell = (IOwnable)properties.get(i);
			if(cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Exchange property.
	 *
	 * @param player the player
	 */
	public void exchangeProperty(Player player) {
		for(int i = 0; i < getPropertyNumber(); i++ ) {
			PropertyCell cell = getProperty(i);
			cell.setOwner(player);
			if(player == null) {
				cell.setAvailable(true);
				cell.setNumHouses(0);
			}
			else {
				player.properties.add(cell);
				playerProduct.getColorGroups().put(
						cell.getColorGroup(), 
						new Integer(playerProduct.getPropertyNumberForColor(cell.getColorGroup())+1));
			}
		}
		properties.clear();
	}
    
    /**
     * Gets the all properties.
     *
     * @return the all properties
     */
    public IOwnable[] getAllProperties() {
        ArrayList<Cell> list = new ArrayList<Cell>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return (IOwnable[])list.toArray(new Cell[list.size()]);
    }

	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public int getMoney() {
		return this.money;
	}
	
	/**
	 * Gets the monopolies.
	 *
	 * @return the monopolies
	 */
	public String[] getMonopolies() {
		return playerProduct.getMonopolies();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the out of jail.
	 *
	 * @return the out of jail
	 */
	public void getOutOfJail() {
		money -= JailCell.BAIL;
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(null);
		}
		inJail = false;
		GameMaster.instance().updateGUI();
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public IOwnable getPosition() {
		return this.position;
	}
	
	/**
	 * Gets the property.
	 *
	 * @param index the index
	 * @return the property
	 */
	public PropertyCell getProperty(int index) {
		return (PropertyCell)properties.get(index);
	}
	
	/**
	 * Gets the property number.
	 *
	 * @return the property number
	 */
	public int getPropertyNumber() {
		return properties.size();
	}

	/**
	 * Checks if is bankrupt.
	 *
	 * @return true, if is bankrupt
	 */
	public boolean isBankrupt() {
		return money <= 0;
	}

	/**
	 * Checks if is in jail.
	 *
	 * @return true, if is in jail
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * Number of RR.
	 *
	 * @return the int
	 */
	public int numberOfRR() {
		return playerProduct.getPropertyNumberForColor(RailRoadCell.COLOR_GROUP);
	}

	/**
	 * Number of util.
	 *
	 * @return the int
	 */
	public int numberOfUtil() {
		return playerProduct.getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
	}
	
	/**
	 * Pay rent to.
	 *
	 * @param owner the owner
	 * @param rentValue the rent value
	 */
	public void payRentTo(Player owner, int rentValue) {
		if(money < rentValue) {
			owner.money += money;
			money -= rentValue;
		}
		else {
			money -= rentValue;
			owner.money +=rentValue;
		}
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(owner);
		}
	}
	
	/**
	 * Purchase.
	 */
	public void purchase() {
		if(getPosition().isAvailable()) {
			IOwnable c = getPosition();
			c.setAvailable(false);
			if(c instanceof PropertyCell) {
				PropertyCell cell = (PropertyCell)c;
				purchaseProperty(cell);
			}
			if(c instanceof RailRoadCell) {
				RailRoadCell cell = (RailRoadCell)c;
				purchaseRailRoad(cell);
			}
			if(c instanceof UtilityCell) {
				UtilityCell cell = (UtilityCell)c;
				purchaseUtility(cell);
			}
		}
	}
	
	/**
	 * Purchase house.
	 *
	 * @param selectedMonopoly the selected monopoly
	 * @param houses the houses
	 */
	public void purchaseHouse(String selectedMonopoly, int houses) {
		GameBoard gb = GameMaster.instance().getGameBoard();
		PropertyCell[] cells = gb.getPropertiesInMonopoly(selectedMonopoly);
		if((money >= (cells.length * (cells[0].getHousePrice() * houses)))) {
			for(int i = 0; i < cells.length; i++) {
				int newNumber = cells[i].getNumHouses() + houses;
				if (newNumber <= 5) {
					cells[i].setNumHouses(newNumber);
					this.setMoney(money - (cells[i].getHousePrice() * houses));
					GameMaster.instance().updateGUI();
				}
			}
		}
	}
	
	/**
	 * Purchase property.
	 *
	 * @param cell the cell
	 */
	private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
	}

	/**
	 * Purchase rail road.
	 *
	 * @param cell the cell
	 */
	private void purchaseRailRoad(RailRoadCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

	/**
	 * Purchase utility.
	 *
	 * @param cell the cell
	 */
	private void purchaseUtility(UtilityCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

    /**
     * Sell property.
     *
     * @param property the property
     * @param amount the amount
     */
    public void sellProperty(IOwnable property, int amount) {
        property.setOwner(null);
        if(property instanceof PropertyCell) {
            properties.remove(property);
        }
        if(property instanceof RailRoadCell) {
            railroads.remove(property);
        }
        if(property instanceof UtilityCell) {
            utilities.remove(property);
        }
        setMoney(getMoney() + amount);
    }

	/**
	 * Sets the in jail.
	 *
	 * @param inJail the new in jail
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/**
	 * Sets the money.
	 *
	 * @param money the new money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the position.
	 *
	 * @param newPosition the new position
	 */
	public void setPosition(IOwnable newPosition) {
		this.position = newPosition;
	}

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return name;
    }
    
    /**
     * Reset property.
     */
    public void resetProperty() {
    	properties = new ArrayList<PropertyCell>();
    	railroads = new ArrayList<Cell>();
    	utilities = new ArrayList<Cell>();
	}
}
