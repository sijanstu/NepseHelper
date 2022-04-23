package Connection;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Sijan Bhandari
 */
public class DBFirebase {

    public static void initFirebase() throws FileNotFoundException, IOException {
        if (databaseFirestore == null) {
            InputStream serviceAccount = new FileInputStream("src/config/servicekey.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);
            databaseFirestore = FirestoreClient.getFirestore();
            System.out.println("Started firebase");
        }
    }
    public static Firestore databaseFirestore = null;

}
