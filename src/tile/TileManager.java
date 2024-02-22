package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) throws IOException {
        this.gp = gp;

        tile = new Tile[10]; // Creating 10 kinds of tiles

        getTileImage();
    }

    public void getTileImage() throws IOException {

        tile[0] = new Tile();
        tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tile_floor.png")));

        tile[1] = new Tile();
        tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tile_wall.png")));

        tile[2] = new Tile();
        tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tile_water.png")));



    }
}
