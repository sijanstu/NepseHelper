package hamroapi;

import hamroshare.config.HamroPath;
import hamroshare.ui.Technical;
import static hamroshare.ui.Technical.company;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Sijan Bhandari
 */
public class StockPrices {

    public static List<String> companyList = null;

    public static double[] getCompanyPrices() throws MalformedURLException, IOException {
        company = company.replace(".csv", "");
        company = company.toUpperCase() + ".csv";
        Document page = Jsoup.parse(new URL(HamroPath.HistoricNepse + company), 20000);
        Elements rows = page.getElementsByTag("tr");
        rows.remove(0);
        double[] prices = new double[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            prices[i] = Double.parseDouble(rows.get(i).child(5).text());
        }
        return prices;
    }

    public static void getCompanyList() throws MalformedURLException, IOException {
        if (companyList == null) {
            String content = IOUtils.toString(new URL(HamroPath.HistoricNepse).openStream());
            Document page = Jsoup.parse(content);
            Elements rows = page.getElementsByAttributeValue("role", "grid").get(0).getElementsByTag("a");
            rows.remove(0);
            companyList = new ArrayList<>();
            for (Element row : rows) {
                companyList.add(row.text());
            }
        }
    }

    public static void fetchCompaniesInJComboBox(JComboBox comboBox) {
        StockPrices.comboBox = comboBox;
        new FetchCompaniesInThread().start();
    }
    static JComboBox comboBox;

    static private class FetchCompaniesInThread extends Thread {

        @Override
        public void run() {
            try {
                getCompanyList();
                comboBox.removeAllItems();
                for (String name : companyList) {
                    comboBox.addItem(name.replace(".csv", ""));
                }
                Technical.initChart(companyList.get(0).replace(".csv", ""));
            } catch (IOException ex) {
                System.out.println("couldn't get Company list");
                Logger.getLogger(StockPrices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
