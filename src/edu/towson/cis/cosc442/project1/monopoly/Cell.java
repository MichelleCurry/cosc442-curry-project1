package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Cell implements IOwnable {
	private String name;
	protected Player theOwner;
	private boolean available = true;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Player getOwner() {
		return theOwner;
	}
	
	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public abstract boolean playAction(String msg);

	void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(Player owner) {
		this.theOwner = owner;
	}
    
    @Override
	public String toString() {
        return name;
    }

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
