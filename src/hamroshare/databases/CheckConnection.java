package hamroshare.databases;

import hamroshare.config.HamroPath;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import org.apache.commons.io.IOUtils;

/**
 * @author Sijan Bhandari
 */
public class CheckConnection extends Thread {

    public static boolean isConnected = false;

    public static void getConnection() throws SQLException {
        CheckConnection con = new CheckConnection();
        con.start();
    }

    @Override
    public void run() {
        String urlString = HamroPath.ApiHome+"/user/test/";
        try {
            String value = IOUtils.toString(new URL(urlString).openStream());
            if(value.equals("true")){
                isConnected=true;
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getCause());
        }
    }
}
