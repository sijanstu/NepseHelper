package hamroshare.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static String server = "localhost";
    static String port = "3306";
    static String database = "companies";
    static String user = "root";
    static String pass = "";
    public static Connection connection;
    public static Connection getConnection(){
        if(connection==null) {
            String url = "jdbc:mysql://" + server + ":" + port + "/" + database+"?rewriteBatchedStatements=true";
            try {
                Connector.connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println(e);
            }
            System.out.println("Connected");
        }
        return connection;
    }
}
