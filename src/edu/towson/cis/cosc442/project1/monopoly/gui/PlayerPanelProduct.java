package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JButton;
import java.io.Serializable;

public class PlayerPanelProduct implements Serializable {
	private JButton btnTrade;

	public JButton getBtnTrade() {
		return btnTrade;
	}

	public void setBtnTrade(JButton btnTrade) {
		this.btnTrade = btnTrade;
	}

	public boolean isTradeButtonEnabled() {
		return btnTrade.isEnabled();
	}

	public void setTradeEnabled(boolean b) {
		btnTrade.setEnabled(b);
	}
}