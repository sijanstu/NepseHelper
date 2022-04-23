package Algorithms;

import static Algorithms.SearchLiveData.companies;
import Connection.NepseApi;
import hamroshare.Model.Company;
import hamroshare.components.LiveTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sijan Bhandari
 */
public class RefreshLiveData extends Thread {

    public static JTable tbl;

    @Override
    public void run() {
        try {
            NepseApi nepseApi = new NepseApi();
            companies = nepseApi.getAllCompanyDirectly();
            for (Company company : companies) {
                DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
                dtm.addRow(new Object[]{company.getSymbol(), company.getClosingprice(), company.getChangePrice(), company.getDifference()});
            }
            changeTable(tbl, 3);
            changeTable(tbl, 2);
            changeTable(tbl, 1);
            changeTable(tbl, 0);
        } catch (IOException ex) {
            Logger.getLogger(LiveTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void changeTable(JTable table, int column_index) {
        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c1 = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (table.getValueAt(row, 3) != null) {
                    float st_val = Float.parseFloat(table.getValueAt(row, 3).toString());
                    float req_val = 0.0f;
                    if (st_val < req_val) {
                        c1.setBackground(new Color(150, 0, 0));
                        c1.setForeground(Color.white);
                    } else {
                        c1.setBackground(Color.GREEN);
                        c1.setForeground(Color.black);
                    }
                } else {
                    c1.setBackground(Color.black);
                    c1.setForeground(Color.white);
                }
                return c1;
            }
        });
    }

}
