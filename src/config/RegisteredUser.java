package config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.Base64;
import com.google.gson.Gson;
import hamroshare.dtos.UserModel;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Sijan Bhandari
 */
public class RegisteredUser extends UserModel {

    public static RegisteredUser registeredUser = new RegisteredUser();

    public static RegisteredUser getStoredUser() throws FileNotFoundException, IOException {
        File file = new File("user.txt");
        if (file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("user.txt")));
            String Uid = new String(Base64.decodeBase64(bufferedReader.readLine()));
            String MachineID = new String(Base64.decodeBase64(bufferedReader.readLine()));
            if (MachineID.equals(getMachineID())) {
                String url = "https://hamroapi.herokuapp.com/susers/" + Uid;
                Document doc = Jsoup.connect(url).ignoreContentType(true).get();
                Gson gson = new Gson();
                registeredUser = gson.fromJson(doc.text(), RegisteredUser.class);
                return registeredUser;
            }
        }
        return null;
    }

    public static RegisteredUser getProfileImage() throws JsonProcessingException, IOException {
        String json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(registeredUser);
        registeredUser = new Gson().fromJson(Jsoup.connect("https://hamroapi.herokuapp.com/login/getimage").userAgent("Mozilla").header("content-type", "application/json").requestBody(json).ignoreContentType(true).post().text(), RegisteredUser.class);
        return registeredUser;
    }

    public static boolean storeUser() throws IOException {
        File file = new File("user.txt");
        if (file.exists()) {
            try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                String toStore = Base64.encodeBase64String(registeredUser.getUid().getBytes()) + "\n"
                        + Base64.encodeBase64String(getMachineID().getBytes());
                bufferedWriter.write(toStore);
            }
            return true;
        }
        return false;
    }

    public static ImageIcon getProfileIcon() throws MalformedURLException {
        return new ImageIcon(new URL(registeredUser.getImageUrl()));
    }

    public static ImageIcon getProfileIconResized(Rectangle rect) throws MalformedURLException {
        return new ImageIcon(new ImageIcon(new URL(registeredUser.getImageUrl())).getImage().getScaledInstance(rect.height, rect.width, java.awt.Image.SCALE_SMOOTH));

    }

    public static boolean signOutUser() {
        new File("user.txt").delete();
        registeredUser = new RegisteredUser();
        return true;
    }

    private static String getMachineID() throws IOException {
        String command = "wmic csproduct get UUID";
        StringBuilder output = new StringBuilder();

        Process SerNumProcess = Runtime.getRuntime().exec(command);
        BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));

        String line;
        while ((line = sNumReader.readLine()) != null) {
            output.append(line).append("\n");
        }
        String MachineID = output.toString().substring(output.indexOf("\n"), output.length()).trim();
        return MachineID;
    }
}
