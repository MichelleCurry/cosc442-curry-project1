package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;

public class GameBoardProductProduct {
	private ArrayList<Cell> cells = new ArrayList<Cell>();

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public Cell getCell(int newIndex) {
		return (Cell) cells.get(newIndex);
	}

	public int getCellNumber() {
		return cells.size();
	}

	public Cell queryCell(String string) {
		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}

	public int queryCellIndex(String string) {
		for (int i = 0; i < cells.size(); i++) {
			IOwnable temp = (IOwnable) cells.get(i);
			if (temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}
}