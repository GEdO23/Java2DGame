package tile;

import main.ImageReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tile {

    public BufferedImage image;
    public boolean collision = false;

    public Tile() {
    }

    public Tile(BufferedImage image) {
        this.image = image;
    }

    public Tile(BufferedImage image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }

    public static ArrayList<Tile> getTiles(String folderPath) {

        File folder = new File("res/" + folderPath);
        File[] files = folder.listFiles();

        Tile[] tile = new Tile[files.length];

        ArrayList<Tile> tileSet = new ArrayList<>();

        try {
            String filePath;

            for (int i = 0; i < files.length; i++) {
                tile[i] = new Tile();
                filePath = folderPath + "/tile" + (i+1) + ".png";
                System.out.println(filePath);
                tile[i].image = ImageReader.readImage(filePath);
                tileSet.add( tile[i] );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tileSet;
    }
}
