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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.XElements;
import us.codecraft.xsoup.Xsoup;

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
            companies = getData();
            if(companies.length<1){
                companies=new NepseApi().getAllCompanyDirectly();
            }
            for (Company company : companies) {
                DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
                dtm.addRow(new Object[]{company.getSymbol(), company.getTransaction(), company.getChangePrice(), company.getDifference()});
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
    static Company[] getData() throws IOException {
        Document document = Jsoup.connect("http://www.nepalstock.com/stocklive").ignoreContentType(true).get();
        //Elements elements=document.getElementsByTag("tbody").get(0).getAllElements();
        XElements elementss = Xsoup.compile("//*[@id=\"home-contents\"]/div[3]/table/tbody").evaluate(document);
        Elements elements = elementss.getElements().get(0).getElementsByTag("tr");
        Company[] companies = new Company[elements.size()];
        updateDate=Xsoup.compile("//*[@id=\"market-watch\"]/div[1]").evaluate(document).getElements().text();
        for (Element element : elements) {
            int index = Integer.parseInt(element.getElementsByTag("td").get(0).text().replace(".", "")) - 1;
            companies[index] = new Company();
            companies[index].setSymbol(element.getElementsByTag("td").get(1).text());
            companies[index].setTransaction(element.getElementsByTag("td").get(2).text());
            companies[index].setLtv(element.getElementsByTag("td").get(3).text());
            companies[index].setChangePrice(element.getElementsByTag("td").get(4).text());
            companies[index].setDifference(element.getElementsByTag("td").get(5).text());
            companies[index].setOpenprice(element.getElementsByTag("td").get(6).text());
            companies[index].setMaxprice(element.getElementsByTag("td").get(7).text());
            companies[index].setMinprice(element.getElementsByTag("td").get(8).text());
            companies[index].setQuantity(element.getElementsByTag("td").get(9).text());
            companies[index].setClosingprice(element.getElementsByTag("td").get(10).text());
        }
        return companies;
    }
}
