package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Image {

    public BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }

}
