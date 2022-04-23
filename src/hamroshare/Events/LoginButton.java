package hamroshare.Events;
import hamroshare.DataBase.LoginController;
import hamroshare.components.Login;
import java.io.IOException;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginButton {

    public void clicked(Login jframe) throws IOException {
        
        LoginController.getUser(jframe);
    }
}
