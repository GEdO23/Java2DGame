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
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S, KeyEvent.VK_X:
                downPressed = true;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                rightPressed = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S, KeyEvent.VK_X:
                downPressed = false;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                rightPressed = false;
                break;
        }

    }
}
