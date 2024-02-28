package tile;

import main.GamePanel;
import main.ImageReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    ArrayList< ArrayList<Tile> > tiles = new ArrayList<>();
    String[][] mapTileNum;
    int tileType;
    int tileIndex = 0;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        mapTileNum = new String[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/map03.txt");
    }

    public void getTileImage() {

        tiles.add(GrassTile.getGrassTiles());


    }


    public void loadMap(String filePath) {

        try {


            // Reading the map file
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            /*
            System.out.println("Class: " + getClass());
            System.out.println("FilePath: " + filePath);
            System.out.println("InputStream: " + inputStream);
            System.out.println("BufferedReader: " + bufferedReader); // String

            String line = bufferedReader.readLine();
            System.out.println("Linha 1: " + line);
            String[] column = line.split(" ");
            System.out.println("Coluna 1: " + column[0]);
            String[] code = column[0].split("-");
            int tileType = Integer.parseInt(code[0]);
            int tileIndex = Integer.parseInt(code[1]);
            System.out.println("TileType: " + tileType);
            System.out.println("TileIndex: " + tileIndex);
            */




            /* Leia o arquivo de texto

            Cada linha do arquivo será adcionada a uma lista
            [
                linha1,
                linha2,
                linha3
            ]

            Cada linhas possui colunas, iremos identificar essas colunas e colocar na lista linha
            [
                [ coluna1, coluna2, coluna3 ],
                [ coluna1, coluna2, coluna3 ],
                [ coluna1, coluna2, coluna3 ]
            ]

            Cada coluna possui um código com o seguinte formato x-y
            O x é o tipo de tile (grama, agua, pedra)
            O y é o index do tile (posição ou formato do tile)

            Devo dividir cada coluna em uma lista com o x e o y
            [
                [ [ x, y ], [ x, y ], [ x, y ] ],
                [ [ x, y ], [ x, y ], [ x, y ] ],
                [ [ x, y ], [ x, y ], [ x, y ] ]
            ]

            arquivo;
            linha1 = arquivo[0];
            coluna1 = linha1[0];
            x1 = coluna1[0]; // tileType
            y1 = coluna1[1]; // tileIndex

            // [linha][coluna][opção]
            x1 = arquivo[0][0][0];
            y1 = arquivo[0][0][1];

            tiles.get( arquivo[0][0][0] ).get( arquivo[0][0][1] ).image
            tiles.get(tileType).get(tileIndex).image
             */

//            int col = 0;
//            int row = 0;
//            while (row < gp.maxScreenRow) {
//
//                String line = bufferedReader.readLine();
//
//                while (col < gp.maxScreenCol) {
//                    String[] numbers = line.split(" ");
//                    int num = Integer.parseInt(numbers[col]);
//
//                    mapTileNum[col][row] = num;
//                    col++;
//                }
//                col = 0;
//                row++;
//            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            g2.drawImage(
                    tiles.get(tileType).get(tileIndex).image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
