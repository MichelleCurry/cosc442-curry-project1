package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import edu.towson.cis.cosc442.project1.monopoly.*;

public class GUITradeDialog extends JDialog implements TradeDialog {
    private GUITradeDialogProduct gUITradeDialogProduct = new GUITradeDialogProduct();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCancel;
    private JComboBox<Object> cboSellers;

    private TradeDeal deal;
    private JTextField txtAmount;
    
    public GUITradeDialog(Frame parent) {
        super(parent);
        
        setTitle("Trade Property");
        cboSellers = new JComboBox<Object>();
        gUITradeDialogProduct.setCboProperties(new JComboBox<Object>());
        txtAmount = new JTextField();
        gUITradeDialogProduct.setBtnOK(new JButton("OK"));
        btnCancel = new JButton("Cancel");
        
        gUITradeDialogProduct.getBtnOK().setEnabled(false);
        
        buildSellersCombo();
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(new JLabel("Sellers"));
        contentPane.add(cboSellers);
        contentPane.add(new JLabel("Properties"));
        contentPane.add(gUITradeDialogProduct.getCboProperties());
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtAmount);
        contentPane.add(gUITradeDialogProduct.getBtnOK());
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                GUITradeDialog.this.hide();
            }
        });
        
        cboSellers.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                Player player = (Player)e.getItem();
                gUITradeDialogProduct.updatePropertiesCombo(player);
            }
        });
        
        gUITradeDialogProduct.getBtnOK().addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                int amount = 0;
                try{
                    amount = Integer.parseInt(txtAmount.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(GUITradeDialog.this,
                            "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                IOwnable cell = (IOwnable)gUITradeDialogProduct.getCboProperties().getSelectedItem();
                if(cell == null) return;
                Player player = (Player)cboSellers.getSelectedItem();
                Player currentPlayer = GameMaster.instance().getCurrentPlayer();
                if(currentPlayer.getMoney() > amount) { 
	                deal = new TradeDeal();
	                deal.setAmount(amount);
	                deal.setPropertyName(cell.getName());
	                deal.setSellerIndex(GameMaster.instance().getPlayerIndex(player));
                }
                hide();
            }
        });
        
        this.pack();
    }

    private void buildSellersCombo() {
        List<?> sellers = GameMaster.instance().getSellerList();
        for (Iterator<?> iter = sellers.iterator(); iter.hasNext();) {
            Player player = (Player) iter.next();
            cboSellers.addItem(player);
        }
        if(sellers.size() > 0) {
            gUITradeDialogProduct.updatePropertiesCombo((Player)sellers.get(0));
        }
    }

    public TradeDeal getTradeDeal() {
        return deal;
    }

}
