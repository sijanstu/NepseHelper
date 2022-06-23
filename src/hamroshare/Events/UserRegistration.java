package hamroshare.Events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import config.RegisteredUser;
import hamroshare.dtos.UserModel;
import hamroshare.ui.Dash;
import hamroshare.ui.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sijan Bhandari
 */
public class UserRegistration extends Thread {

    static Login login = new Login();
    static UserModel user = new UserModel();

    public static void register(Login login, UserModel user) {
        UserRegistration.login = login;
        UserRegistration.user = user;
        new UserRegistration().start();
    }

    @Override
    public void run() {
        try {
            String urlPost = "https://hamroapi.herokuapp.com/login/sijan";
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(user);
            System.out.println(json);
            Document doc = Jsoup.connect(urlPost)
                    .userAgent("Mozilla")
                    .header("content-type", "application/json")
                    .header("accept", "application/json")
                    .requestBody(json)
                    .ignoreContentType(true)
                    .post();
            Gson gson = new Gson();
            RegisteredUser registeredUser=gson.fromJson(doc.text(), RegisteredUser.class);
            if(registeredUser.getUid()!=null){
                RegisteredUser.registeredUser=registeredUser;
                Dash.main();
                login.dispose();
                RegisteredUser.storeUser();
            }
        } catch (IOException ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
