package edu.towson.cis.cosc442.project1.monopoly;

public interface IOwnable {

	String getName();

	Player getOwner();

	int getPrice();

	boolean playAction(String msg);

	void setOwner(Player owner);

	String toString();

	boolean isAvailable();

	void setAvailable(boolean available);

}