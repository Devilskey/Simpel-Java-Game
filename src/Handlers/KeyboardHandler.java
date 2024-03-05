package Handlers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    static boolean[] KeyCodePressed = new boolean[120];
    public static Boolean Key_W = false;
    public static Boolean Key_S = false;
    public static Boolean Key_A = false;
    public static Boolean Key_D = false;
    public static Boolean Key_Space = false;

    public static void CheckIfButtonMapIspressed() {
        Key_W = KeyCodePressed[KeyEvent.VK_W];
        Key_S = KeyCodePressed[KeyEvent.VK_S];
        Key_A = KeyCodePressed[KeyEvent.VK_A];
        Key_D = KeyCodePressed[KeyEvent.VK_D];
        Key_Space = KeyCodePressed[KeyEvent.VK_SPACE];
    }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyReleased(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = true;
    }
}
