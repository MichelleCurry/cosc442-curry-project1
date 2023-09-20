package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Cell {
	private boolean available = true;
	private String name;
	protected Player theOwner;

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return theOwner;
	}
	
	public int getPrice() {
		return 0;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	void setName(String name) {
		this.name = name;
	}

	public void setOwner(Player owner) {
		this.theOwner = owner;
	}
    
    public String toString() {
        return name;
    }
}
