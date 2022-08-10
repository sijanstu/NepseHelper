package hamroshare.mainpackage;

import hamroshare.dtos.StockDto;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Sijan
 */
public class TestClass {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, MalformedURLException, IOException {
        List<List<String>> records = downloadStocks();
        List<StockDto> stocks = new ArrayList<>();
        for (List<String> list : records) {
            System.out.println(list);
            StockDto stock = new StockDto();
            stock.setDate(list.get(1));
            stock.setSecurityId(list.get(2));
            stock.setSymbol(list.get(3));
            stock.setName(list.get(4));
            stock.setOpen(list.get(5));
            stock.setHigh(list.get(6));
            stock.setLow(list.get(7));
            stock.setClose(list.get(8));
            stock.setVolume(list.get(9));
            stock.setPreviousClose(list.get(11));
            stock.setFiftyTwoWeekHigh(list.get(12));
            stock.setFiftyTwoWeekLow(list.get(13));
            stock.setLastUpdatedTime(list.get(14));
            stock.setLastUpdatedPrice(list.get(15));
            stock.setTotalTradedVolume(list.get(16));
            stock.setAverageTradedPrice(list.get(17));
            stock.setMarketCapitalization(list.get(18));
            stocks.add(stock);
        }
        System.out.println(stocks);
    }

    public static void enableSSLSocket() throws KeyManagementException, NoSuchAlgorithmException {
        HttpsURLConnection.setDefaultHostnameVerifier((String hostname, SSLSession session) -> true);

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new X509TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try ( Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static List<List<String>> downloadStocks() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        enableSSLSocket();
        Instant now = Instant.now();
        int minusDays = 0;
        int count = 0;
        while (true) {
            Instant day = now.minus(minusDays, ChronoUnit.DAYS);
            Date date = new Date(day.toEpochMilli());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String dateString = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            System.out.println(dateString);
            URL url = new URL("https://newweb.nepalstock.com/api/nots/market/export/todays-price/" + dateString);
            String content;
            content = IOUtils.toString(url.openStream());
            if (!content.equals("")) {
                List<List<String>> records = new ArrayList<>();
                try ( Scanner scanner = new Scanner(content)) {
                    while (scanner.hasNextLine()) {
                        records.add(getRecordFromLine(scanner.nextLine()));
                    }
                }
                records.remove(0);
                System.out.println(records);
                return records;
            } else {
                minusDays++;
                count++;
            }
            if (count > 20) {
                return null;
            }
        }
    }
}
