package Algorithms;

import Connection.NepseApi;
import hamroshare.Model.Company;
import hamroshare.customswings.GaugeChart;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Sijan Bhandari
 */
public class DashBoard extends Thread {

    public static GaugeChart gaugeChart;
    public static JPanel nepseIndex;

    @Override
    public void run() {
        try {
            NepseApi nepseApi = new NepseApi();
            Company[] companies = nepseApi.getAllCompanyDirectly();
            int positiveCompanies = 0;
            int totalCompanies = companies.length;
            for (Company company : companies) {
                if (company.getChangePrice() != null) {
                    if (Float.parseFloat(company.getDifference()) > 0.0) {
                        positiveCompanies++;
                    }
                } else {
                    totalCompanies--;
                }
            }
            int percentage = positiveCompanies * 100 / totalCompanies;
            gaugeChart.setValueWithAnimation(percentage);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
