package hamroshare.Events;
import hamroshare.DataBase.LoginController;
import hamroshare.components.Login;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginButton {

    public void clicked(Login jframe) {
        LoginController.getUser(jframe);
    }
}
