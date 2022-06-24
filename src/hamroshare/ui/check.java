package hamroshare.ui;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.StorageClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan
 */
public class check {

    static FirebaseApp firebaseApp;

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("user.png");
        initFirebaseSDK();
        StorageClient storageClient = StorageClient.getInstance(firebaseApp);
        InputStream testFile = new FileInputStream("user.png");
        String blobString = "Vaadin/" + "user.png";
        Blob blob = storageClient.bucket().create(blobString, testFile);
        System.out.println(blob.getName());
        Blob blob1 = storageClient.bucket().get(blob.getName());
        byte[] newbyte = blob1.getContent();
        System.out.println(blob.signUrl(999999,TimeUnit.DAYS));

    }

    public static void initFirebaseSDK() throws IOException {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/hamroshare.config/servicekey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("jmav-2bc1e.appspot.com").setStorageBucket("jmav-2bc1e.appspot.com")
                    .build();

            firebaseApp = FirebaseApp.initializeApp(options);
            FirebaseAuth.getInstance(firebaseApp);

        } catch (Exception exc) {
            System.out.println("Firebase exception " + exc);

        }
    }

    static byte[] getByteFromFile(File file) {
        FileInputStream fl = null;
        try {
            fl = new FileInputStream(file);
            byte[] arr = new byte[(int) file.length()];
            fl.read(arr);
            fl.close();
            return arr;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fl.close();
            } catch (IOException ex) {
                Logger.getLogger(check.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
