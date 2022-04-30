package dataalgorithms;

import static dataalgorithms.LiveDataAlgo.tbl;
import hamroshare.dtos.Company;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sijan Bhandari
 */
public class SearchDataAlgo {

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
        LiveDataAlgo.changeTable(tbl, 3);
        LiveDataAlgo.changeTable(tbl, 2);
        LiveDataAlgo.changeTable(tbl, 1);
        LiveDataAlgo.changeTable(tbl, 0);
    }
}
