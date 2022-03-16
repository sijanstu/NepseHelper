package Events;
import DataBase.LoginController;
import Main.Swings.Login;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginButton {

    public void clicked(Login jframe) {
        LoginController.getUser(jframe);
    }
}
