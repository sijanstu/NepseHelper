package Algorithms;

import static Algorithms.RefreshLiveData.tbl;
import hamroshare.Model.Company;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sijan Bhandari
 */
public class SearchLiveData {

    public static Company[] companies;

    public static void displayToTable(String key) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        if (key.equals("")) {
            for (Company company : companies) {
                dtm.addRow(new Object[]{company.getSymbol(), company.getClosingprice(), company.getChangePrice(), company.getDifference()});
            }
        } else {
            for (Company company : companies) {
                if (company.getSymbol().toLowerCase().startsWith(key.toLowerCase())) {
                    dtm.addRow(new Object[]{company.getSymbol(), company.getClosingprice(), company.getChangePrice(), company.getDifference()});
                }
            }
        }
        RefreshLiveData.changeTable(tbl, 3);
        RefreshLiveData.changeTable(tbl, 2);
        RefreshLiveData.changeTable(tbl, 1);
        RefreshLiveData.changeTable(tbl, 0);
    }
}
