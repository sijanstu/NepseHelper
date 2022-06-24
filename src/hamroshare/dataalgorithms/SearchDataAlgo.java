package hamroshare.dataalgorithms;

import static hamroshare.dataalgorithms.LiveDataAlgo.tbl;
import hamroshare.dtos.CompanyDto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sijan Bhandari
 */
public class SearchDataAlgo {

    public static CompanyDto[] companies;

    public static void displayToTable(String key) {
        ((DefaultTableModel) tbl.getModel()).setNumRows(0);
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        if (key.equals("")) {
            for (CompanyDto company : companies) {
                dtm.addRow(new Object[]{company.getSymbol(), company.getClosingPrice(), company.getChange(), company.getDifference()});
            }
        } else {
            for (CompanyDto company : companies) {
                if (company.getSymbol().toLowerCase().startsWith(key.toLowerCase())) {
                    dtm.addRow(new Object[]{company.getSymbol(), company.getClosingPrice(), company.getChange(), company.getDifference()});
                }
            }
        }
        LiveDataAlgo.changeTable(tbl, 3);
        LiveDataAlgo.changeTable(tbl, 2);
        LiveDataAlgo.changeTable(tbl, 1);
        LiveDataAlgo.changeTable(tbl, 0);
    }
}
