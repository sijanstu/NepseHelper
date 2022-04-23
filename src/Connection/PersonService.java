package Connection;

/**
 *
 * @author Sijan Bhandari
 */
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.gson.Gson;
import hamroshare.Model.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sijan Bhandari
 */
public class PersonService {

    static public boolean checkPersonNameAvailability(String username) throws InterruptedException, ExecutionException {
        List<QueryDocumentSnapshot> documents = DBFirebase.databaseFirestore.collection("users").whereEqualTo("username", username).get().get().getDocuments();
        System.out.println(documents.size());
        return documents.isEmpty();
    }

    static public Person authUser(String username, String password) throws MalformedURLException, IOException, JSONException {
        StringBuilder result = new StringBuilder();
        String urlString = "https://hamroapi.herokuapp.com/login/sijan/" + username + "/" + password;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null;) {
                result.append(line);
            }
        }
        String response = result.toString();
        JSONObject responseObject = new JSONObject(response);
        Gson gson = new Gson();
        return gson.fromJson(responseObject.toString(), Person.class);
    }

    static public Person checkPersonAvailability(String username, String password) {
        try {
            DocumentSnapshot documentSnapshot = DBFirebase.databaseFirestore.collection("users").whereEqualTo("username", username).whereEqualTo("password", password).get().get().getDocuments().get(0);
            if (documentSnapshot.exists()) {
                Person user = documentSnapshot.toObject(Person.class);
                return user;
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    static public boolean deletePerson(String uid) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> writeResult = DBFirebase.databaseFirestore.collection("users").document(uid).delete();
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
        return true;
    }

    static public boolean checkuserUidAvailability(String uid) {
        try {
            DocumentSnapshot documentSnapshot = DBFirebase.databaseFirestore.collection("users").document(uid).get().get();
            return documentSnapshot.exists();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    static public Person addPerson(Person user) throws InterruptedException, ExecutionException {
        System.out.println(user.getLastName());
        UUID uniqueKey = UUID.randomUUID();
        user.setUid(String.valueOf(uniqueKey));
        System.out.println(user);
        ApiFuture<WriteResult> docRef = DBFirebase.databaseFirestore.collection("users").document(String.valueOf(user.getUid())).set(user);
        System.out.println(docRef.get().getUpdateTime().toString());
        return user;
    }

    static public Person getPerson(String uid) throws InterruptedException, ExecutionException {
        DocumentSnapshot documentSnapshot = DBFirebase.databaseFirestore.collection("users").document(uid).get().get();
        if (documentSnapshot.exists()) {
            Person user = documentSnapshot.toObject(Person.class);
            return user;
        }
        return null;
    }

    static public Person[] getAllPersons() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> query = DBFirebase.databaseFirestore.collection("users").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        Person[] userarr = new Person[documents.size()];
        int i = 0;
        for (QueryDocumentSnapshot document : documents) {
            userarr[i] = document.toObject(Person.class);
            i++;
        }
        return userarr;
    }

    static void getUser() {

    }
}
