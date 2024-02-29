package tile;

import main.GamePanel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileManager {

    GamePanel gp;
    ArrayList< ArrayList<Tile> > tiles = new ArrayList<>();
    int[][] mapTileNum;


    public TileManager(GamePanel gp) {
        this.gp = gp;

        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/map03.txt");
    }

    public void getTileImage() {

        tiles.add(Tile.getTiles("/tiles/grass_dirt"));
//        tiles.add(Tile.getTiles("/tiles/concrete_path"));
    }


    public void loadMap(String filePath) {

        try {

            // Reading the map file
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;
            String line;
            while (( line = bufferedReader.readLine() )!= null) {

                String[] column = line.split(" ");

                for (int col = 0; col < gp.maxScreenCol; col++) {

                    String[] code = column[col].split("-");
                    int tileTypeId = Integer.parseInt(code[0]);
                    int tileIndex = Integer.parseInt(code[1]);

                    mapTileNum[col][row] = tileTypeId * 10 + tileIndex;

                }

                row++;

            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {


        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {

                int tileCode = mapTileNum[col][row];

                int tileTypeId = tileCode / 10;
                int tileIndex = tileCode % 10;

                if (tileTypeId < tiles.size()) {

                    ArrayList<Tile> tileSet = tiles.get(tileTypeId);

                    if(tileIndex < tileSet.size()) {

                        g2.drawImage(tileSet.get(tileIndex).image, col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);

                    }

                }

            }
        }
    }
}
