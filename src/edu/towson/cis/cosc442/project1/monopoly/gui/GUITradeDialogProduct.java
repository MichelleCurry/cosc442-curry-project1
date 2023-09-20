package edu.towson.cis.cosc442.project1.monopoly.gui;


import javax.swing.JButton;
import javax.swing.JComboBox;
import edu.towson.cis.cosc442.project1.monopoly.Player;
import edu.towson.cis.cosc442.project1.monopoly.IOwnable;
import java.io.Serializable;

public class GUITradeDialogProduct implements Serializable {
	private JButton btnOK;
	private JComboBox<Object> cboProperties;

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JComboBox<Object> getCboProperties() {
		return cboProperties;
	}

	public void setCboProperties(JComboBox<Object> cboProperties) {
		this.cboProperties = cboProperties;
	}

	public void updatePropertiesCombo(Player player) {
		cboProperties.removeAllItems();
		IOwnable[] cells = player.getAllProperties();
		btnOK.setEnabled(cells.length > 0);
		for (int i = 0; i < cells.length; i++) {
			cboProperties.addItem(cells[i]);
		}
	}
}