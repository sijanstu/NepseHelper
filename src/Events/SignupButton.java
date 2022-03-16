
package Events;

import DataBase.SignUpController;
import Main.Swings.Login;

/**
 *
 * @author Sijan Bhandari
 */
public class SignupButton {
    public void clicked(Login sign){
        SignUpController.getUser(sign);
    }
}
