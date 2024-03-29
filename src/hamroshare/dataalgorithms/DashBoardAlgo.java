package hamroshare.dataalgorithms;

import com.fasterxml.jackson.databind.ObjectMapper;
import hamroshare.config.HamroFetcher;
import hamroshare.config.HamroPath;
import hamroshare.config.NepseColors;
import hamroshare.dtos.CompanyDto;
import hamroshare.ui.Home;
import hamroshare.uicomponents.GaugeChart;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Sijan Bhandari
 */
class RefreshDash extends TimerTask {

    @Override
    public void run() {
        new DashBoardAlgo().start();
    }
}

public class DashBoardAlgo extends Thread {

    public static void init() {
        Timer timer = new Timer();
        TimerTask timerTask = new RefreshDash();
        timer.schedule(timerTask, 0, 20000);
    }
    public static GaugeChart gaugeChart = Home.gauch;

    @Override
    public void run() {
        int gaugeValue = gaugeChart.getValue();
        try {
            gaugeChart.setValueWithAnimation(0);
            String url = HamroPath.ApiHome+"company/list";
            String json = HamroFetcher.getData(url);
            //Document doc = Jsoup.connect(url)
             //   .userAgent("Mozilla")
             //   .header("content-type", "application/json")
             ///   .header("accept", "application/json")
             //   .ignoreContentType(true).get();
            //String json = doc.text();
            //map jsonArray to java array
            CompanyDto[] companies = new ObjectMapper().readValue(json, CompanyDto[].class);
            int positiveCompanies = 0;
            int totalCompanies = companies.length;
            for (CompanyDto company : companies) {
                if (company.getChange()!= null) {
                    if (Float.parseFloat(company.getDifference()) > 0.0) {
                        positiveCompanies++;
                    }
                } else {
                    totalCompanies--;
                }
            }
            int percentage = positiveCompanies * 100 / totalCompanies;
            gaugeChart.setValueWithAnimation(percentage);
            Document page = Jsoup.parse(new URL(HamroPath.NepalStock), 20000);
            // Elements box = page.getElementsByAttributeValueEnding("id","index_slider");
            String name = Xsoup.compile("//*[@id=\"banner\"]/div[1]/div[1]").evaluate(page).getElements().text();
            String value = Xsoup.compile("//*[@id=\"banner\"]/div[1]/div[2]").evaluate(page).getElements().text();
            String change = Xsoup.compile("//*[@id=\"banner\"]/div[1]/div[3]").evaluate(page).getElements().text();
            String percentchange = Xsoup.compile("//*[@id=\"banner\"]/div[1]/div[4]").evaluate(page).getElements().text();
            //Home.nepseName.setText(name + ": " + Home.nepseName.getText());
            Home.indexNepse.setText(value);
            Home.changeNepse.setText(change);
            Home.changePercentageNepse.setText(percentchange);
            System.out.println("complete");
            if (percentage < 30) {
                Home.changePercentageNepse.setForeground(NepseColors.ncolors.getRed());
                Home.changeNepse.setForeground(NepseColors.ncolors.getRed());
                Home.colorIndex.setBackground(NepseColors.ncolors.getRed());
            } else if (percentage < 60) {
                Home.changePercentageNepse.setForeground(Color.YELLOW);
                Home.changeNepse.setForeground(Color.YELLOW);
                Home.colorIndex.setBackground(Color.YELLOW);
            } else {
                Home.changePercentageNepse.setForeground(NepseColors.ncolors.getGreen());
                Home.changeNepse.setForeground(NepseColors.ncolors.getGreen());
                Home.colorIndex.setBackground(NepseColors.ncolors.getGreen());
            }
            if (percentage > 85) {
            }
        } catch (IOException ex) {
          //  try {
                gaugeChart.setValueWithAnimation(gaugeValue);
                //String url = HamroPath.apiHome+"/company/refresh";
                //Document doc = Jsoup.connect(url)
                //        .userAgent("Mozilla")
                 //       .header("content-type", "application/json")
                 //       .header("accept", "application/json")
                 //       .ignoreContentType(true).get();
               // Logger.getLogger(DashBoardAlgo.class.getName()).log(Level.SEVERE, null, ex);
            //} catch (IOException ex1) {
            //    Logger.getLogger(DashBoardAlgo.class.getName()).log(Level.SEVERE, null, ex1);
           // }
        }
    }
}
