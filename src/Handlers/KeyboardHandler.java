package Handlers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    public static Boolean Key_W = false, Key_S = false, Key_A = false, Key_D = false;

    public static void Update() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W)
            Key_W = false;
        if(e.getKeyCode() == KeyEvent.VK_S)
            Key_S = false;
        if(e.getKeyCode() == KeyEvent.VK_A)
            Key_A = false;
        if(e.getKeyCode() == KeyEvent.VK_D)
            Key_D = false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W)
            Key_W = true;
        if(e.getKeyCode() == KeyEvent.VK_S)
            Key_S = true;
        if(e.getKeyCode() == KeyEvent.VK_A)
            Key_A = true;
        if(e.getKeyCode() == KeyEvent.VK_D)
            Key_D = true;
    }
}
