package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = Direction.DOWN;
    }

    private BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }

    public void getPlayerImage() {

        try {

            up1 = getImage("/player/player_up1.png");
            up2 = getImage("/player/player_up2.png");
            down1 = getImage("/player/player_down1.png");
            down2 = getImage("/player/player_down2.png");
            left1 = getImage("/player/player_left1.png");
            left2 = getImage("/player/player_left2.png");
            right1 = getImage("/player/player_right1.png");
            right2 = getImage("/player/player_right2.png");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (keyH.upPressed) {
            direction = Direction.UP;
            y -= speed;
        } else if (keyH.downPressed) {
            direction = Direction.DOWN;
            y += speed;
        } else if (keyH.leftPressed) {
            direction = Direction.LEFT;
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = Direction.RIGHT;
            x += speed;
        }
    }
    public void draw(Graphics g2) {

        getPlayerImage();

        BufferedImage image = null;

        switch (direction) {
            case UP -> image = up1;
            case DOWN -> image = down1;
            case LEFT -> image = left1;
            case RIGHT -> image = right1;
        }

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
