package dataalgorithms;

import static dataalgorithms.SearchDataAlgo.companies;
import hamroshare.databases.NepseApi;
import config.NepseColors;
import hamroshare.dtos.Company;
import hamroshare.ui.LiveTable;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sijan Bhandari
 */
class RefreshTable extends TimerTask {

    @Override
    public void run() {
        new LiveDataAlgo().start();
    }
}

public class LiveDataAlgo extends Thread {

    public static JTable tbl = LiveTable.tbl;

    public static void init() {
        Timer timer = new Timer();
        TimerTask timerTask = new RefreshTable();
        timer.schedule(timerTask, 0, 10000);
    }

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
            LiveTable.date.setText(NepseApi.getDateString());
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
                        c1.setBackground(NepseColors.ncolors.getRed());
                        c1.setForeground(Color.white);
                    } else {
                        c1.setBackground(NepseColors.ncolors.getGreen());
                        c1.setForeground(Color.white);
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
