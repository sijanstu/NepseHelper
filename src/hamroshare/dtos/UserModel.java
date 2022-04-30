package hamroshare.dtos;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;
import config.RegisteredUser;
import hamroshare.databases.DBFirebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sijan Bhandari
 */
public class UserModel {

    String uid;
    String name;
    String username;
    String emailID;
    String password;
    String image;
    String imageUrl;

    public UserModel() {
    }

    public UserModel(String uid, String name, String username, String emailID, String password) {
        this.uid = uid;
        this.name = name;
        this.username = username;
        this.emailID = emailID;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserModel{" + "uid=" + uid + ", name=" + name + ", username=" + username + ", emailID=" + emailID + ", password=" + password + ", image=" + image + ", imageUrl=" + imageUrl + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.uid);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.emailID);
        hash = 41 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserModel other = (UserModel) obj;
        if (!Objects.equals(this.uid, other.uid)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.emailID, other.emailID)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    public boolean doesExist() throws InterruptedException, ExecutionException {
        List<QueryDocumentSnapshot> documentSnapshots = DBFirebase.databaseFirestore.collection("users").whereEqualTo("username", username).whereEqualTo("password", password).get().get().getDocuments();
        if (!documentSnapshots.isEmpty()) {
            switchValue(documentSnapshots.get(0).toObject(UserModel.class));
            return true;
        }
        return false;
    }

    public RegisteredUser authUser() throws MalformedURLException, IOException, JSONException, Throwable {
        StringBuilder result = new StringBuilder();
        String urlString = "https://hamroapi.herokuapp.com/login/sijan/" + username + "/" + password;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        for (String line; (line = reader.readLine()) != null;) {
            result.append(line);
            String response = result.toString();
            JSONObject responseObject = new JSONObject(response);
            Gson gson = new Gson();
            return gson.fromJson(responseObject.toString(), RegisteredUser.class);
        }
        throw new Throwable("Auth error");
    }
    void switchValue(UserModel userModel) {
        uid = userModel.getUid();
        name = userModel.getName();
        username = userModel.getUsername();
        emailID = getEmailID();
        password = getPassword();
        imageUrl = getImageUrl();
    }
}
