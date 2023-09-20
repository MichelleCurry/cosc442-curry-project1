package edu.towson.cis.cosc442.project1.monopoly;


import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerProduct.
 */
public class PlayerProduct {
	
	/** The color groups. */
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();

	/**
	 * Gets the color groups.
	 *
	 * @return the color groups
	 */
	public Hashtable<String, Integer> getColorGroups() {
		return colorGroups;
	}

	/**
	 * Gets the property number for color.
	 *
	 * @param name the name
	 * @return the property number for color
	 */
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer) colorGroups.get(name);
		if (number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Gets the monopolies.
	 *
	 * @return the monopolies
	 */
	public String[] getMonopolies() {
		ArrayList<String> monopolies = new ArrayList<String>();
		Enumeration<String> colors = colorGroups.keys();
		while (colors.hasMoreElements()) {
			String color = (String) colors.nextElement();
			if (!(color.equals(RailRoadCell.COLOR_GROUP)) && !(color.equals(UtilityCell.COLOR_GROUP))) {
				Integer num = (Integer) colorGroups.get(color);
				GameBoard gameBoard = GameMaster.instance().getGameBoard();
				if (num.intValue() == gameBoard.getPropertyNumberForColor(color)) {
					monopolies.add(color);
				}
			}
		}
		return (String[]) monopolies.toArray(new String[monopolies.size()]);
	}
}