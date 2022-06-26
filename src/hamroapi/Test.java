package hamroapi;

import com.google.api.client.util.Base64;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sijan
 */
public class Test {
    public static void initializeFirebase() throws Exception {
        if (FirebaseApp.getApps().isEmpty()) {
            InputStream serviceAccount = new ByteArrayInputStream(Files.readAllBytes(Paths.get("src/main/resources/servicekey.json")));
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options =FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setStorageBucket("jmav-2bc1e.appspot.com")
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("Started firebase");
        }
    }
    public static String storeImage(String imageName, String imageBytes){
        StorageClient storageClient=StorageClient.getInstance(FirebaseApp.getInstance());
        InputStream inputStream=new ByteArrayInputStream(Base64.decodeBase64(imageBytes));
        String blobString = "hamroapiusers/" + imageName+".png";
        Blob blob = storageClient.bucket().create(blobString, inputStream);
        return blob.signUrl(999999,TimeUnit.DAYS).toString();
    }
}
