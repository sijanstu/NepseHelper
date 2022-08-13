package hamroshare.databases;

import hamroshare.config.HamroFetcher;
import hamroshare.config.HamroPath;
import java.io.IOException;
import java.net.MalformedURLException;
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
        String urlString = HamroPath.ApiHome+"/user/test/";
        try {
            String value = HamroFetcher.getData(urlString);
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
