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

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right2.png")));

        } catch (IOException e) {
            throw new RuntimeException(e);
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

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            spriteCounter++;
            if(spriteCounter > 8) {
                spriteNum = spriteNum == 1 ? 2 : 1;
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics g2) {

        getPlayerImage();

        BufferedImage image = switch (direction) {
            case UP -> spriteNum == 1 ? up1 : up2;
            case DOWN -> spriteNum == 1 ? down1 : down2;
            case LEFT -> spriteNum == 1 ? left1 : left2;
            case RIGHT -> spriteNum == 1 ? right1 : right2;
        };

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
