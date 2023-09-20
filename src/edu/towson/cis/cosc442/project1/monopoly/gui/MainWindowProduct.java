package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JPanel;
import edu.towson.cis.cosc442.project1.monopoly.GameBoard;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;

public class MainWindowProduct implements Serializable {
	private JPanel eastPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();

	public JPanel getEastPanel() {
		return eastPanel;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public JPanel getWestPanel() {
		return westPanel;
	}

	public void setupGameBoard(GameBoard board, MainWindow mainWindow) {
		Dimension dimension = GameBoardUtil.calculateDimension(board.getCellNumber());
		northPanel.setLayout(new GridLayout(1, dimension.width + 2));
		southPanel.setLayout(new GridLayout(1, dimension.width + 2));
		westPanel.setLayout(new GridLayout(dimension.height, 1));
		eastPanel.setLayout(new GridLayout(dimension.height, 1));
		mainWindow.addCells(northPanel, GameBoardUtil.getNorthCells(board));
		mainWindow.addCells(southPanel, GameBoardUtil.getSouthCells(board));
		mainWindow.addCells(eastPanel, GameBoardUtil.getEastCells(board));
		mainWindow.addCells(westPanel, GameBoardUtil.getWestCells(board));
		mainWindow.buildPlayerPanels();
	}
}