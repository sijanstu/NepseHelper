package hamroshare.dataalgorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Sijan
 */
public class MD5 {

    public static String generate(String key) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(key.getBytes());
            byte[] digest = messageDigest.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException exception) {
            System.out.println("Algorithm not found");
        }
        return null;
    }
}
