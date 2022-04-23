package hamroshare.DataBase;

import Connection.PersonService;
import hamroshare.Calculation.LastBounds;
import hamroshare.Events.Info;
import hamroshare.Model.Person;
import hamroshare.components.Dash;
import hamroshare.components.Login;
import hamroshare.Model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Sijan Bhandari
 */
public class LoginController extends Thread {

    static String username, pass;
    public static Login lg;
    public static User user;

    @Override
    public void run() {
        Person newPerson = new Person();
        try {
            newPerson = PersonService.authUser(username, pass);
        } catch (IOException | JSONException ex) {
            System.out.println("Error");
        }
        //PersonService.checkPersonAvailability(username, pass);
        if (newPerson != null && newPerson.getUid() != null) {
            user = new User(newPerson.getUid(), newPerson.getUsername());
            LastBounds.storedBound = lg.getBounds();
            Dash.main();
            lg.dispose();

        } else {
            Info.display(lg.jp1, "Not Found", 0, 1000);
        } //l1.interrupt();
    }

    public static void getUser(Login lgn) throws IOException {
        username = lgn.usern.getText();
        pass = lgn.passn.getText();
        lg = lgn;
        new LoginController().start();
    }

}
