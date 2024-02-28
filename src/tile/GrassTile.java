package tile;

import main.ImageReader;

import java.io.IOException;
import java.util.ArrayList;

public class GrassTile extends Tile {

    public static ArrayList<Tile> getGrassTiles() {

        Tile[] tile;
        ArrayList<Tile> tileset = new ArrayList<>();

        tile = new Tile[50];

        try {

            for (int i = 1; i <= 42; i++) {
                tile[i] = new Tile();
                tile[i].image = ImageReader.readImage("/tiles/grass_dirt/tile" + i + ".png");
                tileset.add( tile[i] );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tileset;

    }

}
