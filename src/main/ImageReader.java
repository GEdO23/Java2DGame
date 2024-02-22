package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageReader {

    public static BufferedImage readImage(String filePath) throws IOException {
        return ImageIO.read(Objects.requireNonNull(ImageReader.class.getResourceAsStream(filePath)));
    }

}
