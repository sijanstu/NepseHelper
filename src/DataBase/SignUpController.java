package DataBase;

import Calculation.CloseController;
import Events.Info;
import Dashboard.Dash;
import Main.Swings.Login;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan Bhandari
 */
public class SignUpController extends Thread{
    static String username, pass;
    static Login lg;
    public static User user;
    static LoginController l1;

    @Override
    public void run() {
        try {
            Connection connection = Connector.connection;
            String sql = "select * from User where Username=? and Password=?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, pass);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Info.display(lg.jp1, "Login Success", 1, 2000);
                user = new User(rs.getInt("ID"), rs.getString("Username"));
                Dash d=new Dash();
                Dash.main();
                CloseController.changePosition(d.getBounds());
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
        username=lg.user.getText();
        SignUpController.pass=lg.pass.getText();
        l1 = new LoginController();
        SignUpController.lg = lg;
        l1.start();
    }


}
