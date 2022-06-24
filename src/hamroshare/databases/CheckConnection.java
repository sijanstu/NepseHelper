package hamroshare.databases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

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
        String urlString = "https://hamroapi.herokuapp.com/user/test/";
        try {
            HttpURLConnection huc = (HttpURLConnection) (new URL(urlString).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            isConnected = huc.getResponseCode() == 200;
        } catch (IOException e) {
            isConnected = false;
            throw new RuntimeException(e);
        }
    }
}
