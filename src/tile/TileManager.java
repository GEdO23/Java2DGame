package tile;

import main.GamePanel;
import main.Image;

import java.io.IOException;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    Image image;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10]; // Creating 10 kinds of tiles

        getTileImage();
    }

    public void getTileImage() {

        tile[0] = new Tile();
        tile[1] = new Tile();
        tile[2] = new Tile();

        try {
            tile[0].image = image.getImage("/tiles/tile_floor.png");
            tile[1].image = image.getImage("/tiles/tile_wall.png");
            tile[2].image = image.getImage("/tiles/tile_water.png");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
