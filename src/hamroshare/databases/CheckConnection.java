package hamroshare.databases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan Bhandari
 */
public class CheckConnection extends Thread {

    public static boolean isconnected = false;

    @Override
    public void run() {
        try {
            StringBuilder result = new StringBuilder();
            String urlString = "https://hamroapi.herokuapp.com/login/check/";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try ( BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null;) {
                    result.append(line);
                }
            }
            String response = result.toString();
            isconnected = response.equals("true");
        } catch (IOException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getConnection() throws SQLException {
        CheckConnection con = new CheckConnection();
        con.start();
    }
}
