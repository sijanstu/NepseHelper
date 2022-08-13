package hamroshare.config;

import java.io.IOException;
import org.jsoup.Jsoup;

/**
 *
 * @author Sijan Bhandari
 */
public class HamroFetcher {
    public static String getData(String url) throws IOException{
        return Jsoup.connect(url).ignoreContentType(true).get().getElementsByTag("body").html();
    }
}

