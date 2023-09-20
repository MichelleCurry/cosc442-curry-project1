package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.IOwnable;

public class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(IOwnable cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
