package hamroshare.DataBase;

import hamroshare.Calculation.LastBounds;
import hamroshare.Events.Info;
import hamroshare.components.Dash;
import hamroshare.components.Login;
import hamroshare.Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginController extends Thread {

    static String username, pass;
    static Login lg;
    public static User user;
    static LoginController l1;

    @Override
    public void run() {
        try {
            Connection connection = Connector.connection;
            String sql = "select * from tbl_users where username=? and password=MD5(?);";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, pass);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                user = new User(rs.getInt("ID"), rs.getString("Username"));
                LastBounds.bound=lg.getBounds();
                Dash.main();
                lg.dispose();
            } else {
                Info.display(lg.jp1, "Not Found", 0, 2000);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //l1.interrupt();
    }

    public static void getUser(Login lg) {
        username = lg.user.getText();
        LoginController.pass = lg.pass.getText();
        l1 = new LoginController();
        LoginController.lg = lg;
        l1.start();
    }

}
