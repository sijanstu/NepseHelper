package dataalgorithms;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sijan Bhandari
 */
public class FetchData {

    public static void main(String[] args) throws IOException {
        Connection connection = Jsoup.connect("https://www.nepalstock.com.np/today-price");
        Document body = connection.get();
        System.out.println(body);
    }
}
