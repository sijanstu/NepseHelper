package hamroshare.dataalgorithms;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan
 */
public class ImageAlgo {

    public static byte[] resize(String input, int w, int h) throws IOException {
        BufferedImage image = ImageIO.read(new File(input));
        BufferedImage scaled = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        scaled.getGraphics().drawImage(image, 0, 0, w, h, null);
        byte[] imageInByte;
        try ( ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(scaled, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
        }
        return imageInByte;
    }

    public static BufferedImage byteArrayToImage(String sbytes) {
        byte[] bytes=Base64.getMimeDecoder().decode(sbytes);
        BufferedImage bufferedImage = null;
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bufferedImage;
    }

    public static String ImageToByte(String url) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage bImage = ImageIO.read(new File(url));
            ImageIO.write(bImage, "jpg", bos);
        } catch (IOException ex) {
            Logger.getLogger(ImageAlgo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Base64.getMimeEncoder().encodeToString(bos.toByteArray());
    }
}
