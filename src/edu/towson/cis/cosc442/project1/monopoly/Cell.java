package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Cell {
	private String name;
	protected Player theOwner;
	private boolean available = true;

	public String getName() {
		return name;
	}

	public Player getOwner() {
		return theOwner;
	}
	
	public int getPrice() {
		return 0;
	}

	public abstract void playAction();

	void setName(String name) {
		this.name = name;
	}

	public void setOwner(Player owner) {
		this.theOwner = owner;
	}
    
    public String toString() {
        return name;
    }

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
