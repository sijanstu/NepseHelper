package hamroshare.databases;

import com.google.gson.Gson;
import config.RegisteredUser;
import hamroshare.dtos.UserModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sijan Bhandari
 */
public class getPerson {

    public static void main(String[] args) {
        RegisteredUser userModel = new RegisteredUser();
        userModel.setUsername("sijan");
        userModel.setPassword("sijan");
        try {
            RegisteredUser userModel1 = userModel.authUser();
            if (userModel1.getUid() != null) {
                RegisteredUser.registeredUser = userModel1;
                System.out.println(RegisteredUser.registeredUser);
            }else{
                System.out.println("Not found");
            }

        } catch (JSONException ex) {
            System.out.println("jsonException line 32");
        } catch (Throwable ex) {
            System.out.println("jsonException line 34");
        }
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
