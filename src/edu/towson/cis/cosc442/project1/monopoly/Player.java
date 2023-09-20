package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class Player {
	private PlayerProduct playerProduct = new PlayerProduct();
	private boolean inJail;
	private int money;
	private String name;

	private IOwnable position;
	private ArrayList<PropertyCell> properties = new ArrayList<PropertyCell>();
	private ArrayList<Cell> railroads = new ArrayList<Cell>();
	private ArrayList<Cell> utilities = new ArrayList<Cell>();
	
	public Player() {
		GameBoard gb = GameMaster.instance().getGameBoard();
		inJail = false;
		if(gb != null) {
			position = gb.queryCell("Go");
		}
	}

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
	
	public boolean canBuyHouse() {
		return (playerProduct.getMonopolies().length != 0);
	}

	public boolean checkProperty(String property) {
		for(int i=0;i<properties.size();i++) {
			IOwnable cell = (IOwnable)properties.get(i);
			if(cell.getName().equals(property)) {
				return true;
			}
		}
		return false;
		
	}
	
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
    
    public IOwnable[] getAllProperties() {
        ArrayList<Cell> list = new ArrayList<Cell>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return (IOwnable[])list.toArray(new Cell[list.size()]);
    }

	public int getMoney() {
		return this.money;
	}
	
	public String[] getMonopolies() {
		return playerProduct.getMonopolies();
	}

	public String getName() {
		return name;
	}

	public void getOutOfJail() {
		money -= JailCell.BAIL;
		if(isBankrupt()) {
			money = 0;
			exchangeProperty(null);
		}
		inJail = false;
		GameMaster.instance().updateGUI();
	}

	public IOwnable getPosition() {
		return this.position;
	}
	
	public PropertyCell getProperty(int index) {
		return (PropertyCell)properties.get(index);
	}
	
	public int getPropertyNumber() {
		return properties.size();
	}

	public boolean isBankrupt() {
		return money <= 0;
	}

	public boolean isInJail() {
		return inJail;
	}

	public int numberOfRR() {
		return playerProduct.getPropertyNumberForColor(RailRoadCell.COLOR_GROUP);
	}

	public int numberOfUtil() {
		return playerProduct.getPropertyNumberForColor(UtilityCell.COLOR_GROUP);
	}
	
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
	
	private void purchaseProperty(PropertyCell cell) {
        buyProperty(cell, cell.getPrice());
	}

	private void purchaseRailRoad(RailRoadCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

	private void purchaseUtility(UtilityCell cell) {
	    buyProperty(cell, cell.getPrice());
	}

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

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(IOwnable newPosition) {
		this.position = newPosition;
	}

    public String toString() {
        return name;
    }
    
    public void resetProperty() {
    	properties = new ArrayList<PropertyCell>();
    	railroads = new ArrayList<Cell>();
    	utilities = new ArrayList<Cell>();
	}
}
