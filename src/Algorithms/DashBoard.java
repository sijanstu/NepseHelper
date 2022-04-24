package Algorithms;

import Connection.NepseApi;
import hamroshare.DataBase.Connector1;
import hamroshare.Model.Company;
import hamroshare.components.Home;
import hamroshare.customswings.GaugeChart;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
            if(percentage<30){
                Home.nepseName.setText("Bearish");
                //Home.positivityText.setForeground(Color.red);
                Home.value.setForeground(Color.red);
                Home.change.setForeground(Color.red);
                Home.percentage.setForeground(Color.red);
                Home.nepseName.setForeground(Color.red);
            }else if(percentage<60){
                Home.nepseName.setText("Neutral");
                //Home.positivityText.setForeground(Color.YELLOW);
                Home.value.setForeground(Color.YELLOW);
                Home.change.setForeground(Color.YELLOW);
                Home.percentage.setForeground(Color.YELLOW);
                Home.nepseName.setForeground(Color.yellow);
            }else{
                Home.nepseName.setText("Bullish");
                //Home.positivityText.setForeground(Color.green);
                Home.value.setForeground(Color.green);
                Home.change.setForeground(Color.green);
                Home.percentage.setForeground(Color.green);
                Home.nepseName.setForeground(Color.green);
            }if(percentage>85){
                Home.nepseName.setText("Strong Bullish");
            }
            String URL = "https://www.nepalipaisa.com/StockLive.aspx";
            Connection connection = Connector1.getConnection();
            String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String query = "select * from indexhistory where date='" + dateToday + "' and name='Nepse'";
            ResultSet resultSet;
            resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                Home.value.setText("Nepse Index: " + resultSet.getString("value"));
                Home.change.setText("Change: " + resultSet.getString("changevalue"));
                Home.percentage.setText("Change(%): " + resultSet.getString("difference"));
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
