package hamroshare.dataalgorithms;

import com.fasterxml.jackson.databind.ObjectMapper;
import hamroshare.config.HamroPath;
import hamroshare.config.NepseColors;
import hamroshare.ui.LiveTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import static hamroshare.dataalgorithms.SearchDataAlgo.companies;
import hamroshare.dtos.CompanyDto;
import java.net.URL;
import org.apache.commons.io.IOUtils;

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
        timer.schedule(timerTask, 0, 20000);
    }

    @Override
    public void run() {
        try {
            companies = getData();
            for (CompanyDto company : companies) {
                DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
                dtm.addRow(new Object[]{company.getSymbol(), company.getClosingPrice(), company.getChange(), company.getDifference()});
            }
            changeTable(tbl, 3);
            changeTable(tbl, 2);
            changeTable(tbl, 1);
            changeTable(tbl, 0);
            LiveTable.date.setText(updateDate);
        } catch (IOException ex) {
            Logger.getLogger(LiveTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void changeTable(JTable table, int column_index) {

        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c1 = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (table.getValueAt(row, 2) != null) {
                    float st_val = Float.parseFloat(table.getValueAt(row, 2).toString());
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
static String updateDate="";
    static CompanyDto[] getData() throws IOException {
        String url = HamroPath.ApiHome+"/company/list";
        String json = IOUtils.toString(new URL(url).openStream());
        return new ObjectMapper().readValue(json, CompanyDto[].class);
    }
}
