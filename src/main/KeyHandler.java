package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                upPressed = true;
            case KeyEvent.VK_DOWN:
                downPressed = true;
            case KeyEvent.VK_LEFT:
                leftPressed = true;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                upPressed = false;
            case KeyEvent.VK_DOWN:
                downPressed = false;
            case KeyEvent.VK_LEFT:
                leftPressed = false;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
        }

    }
}
