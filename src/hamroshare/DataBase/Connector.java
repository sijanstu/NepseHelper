package hamroshare.DataBase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;

/**
 *
 * @author Sijan Bhandari
 */
public class Connector extends Thread {

    private final String server = "remotemysql.com";
    private final String port = "3306";
    private final String database = "tP7YdTtjU2";
    private final String user = "tP7YdTtjU2";//"FK1Lof12mK";
    private final String pass = "4HwzFcTZRg";//"wZFHsaqgmT";
    private final String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
    public static Connection connection;
    public static boolean isconnected = false;

    @Override
    public void run() {
        try {
            System.out.println(url);
            connection = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connected");
            isconnected=true;
        } catch (SQLException ex) {
            System.out.println("Not connected");
            isconnected = false;
        }
    }

    public static void getConnection() throws SQLException {
        Timer timer = new Timer();
        timer.schedule(new connectNow(), 0, 40000);
    }
}

class connectNow extends TimerTask {

    @Override
    public void run() {
        Connector con = new Connector();
        con.start();
    }
}
