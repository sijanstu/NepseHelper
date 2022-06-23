/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamroshare.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResizeImage {

    private static final int IMG_WIDTH = 190;
    private static final int IMG_HEIGHT = 190;

    public static void resize(String sourcePath,String targetPath) throws IOException {

        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);

        try (InputStream is = new FileInputStream(source.toFile())) {
            resize(is, target, IMG_WIDTH, IMG_HEIGHT);
        }

    }

    private static void resize(InputStream input, Path target,
                                   int width, int height) throws IOException {

        BufferedImage originalImage = ImageIO.read(input);

        /**
         * SCALE_AREA_AVERAGING
         * SCALE_DEFAULT
         * SCALE_FAST
         * SCALE_REPLICATE
         * SCALE_SMOOTH
         */
        Image newResizedImage = originalImage
              .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        String s = target.getFileName().toString();
        String fileExtension = s.substring(s.lastIndexOf(".") + 1);

        // we want image in png format
        ImageIO.write(convertToBufferedImage(newResizedImage),
                fileExtension, target.toFile());

    }

    public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }

}