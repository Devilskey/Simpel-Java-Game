package engine.Handlers.Peripherals;
import Statics.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    static boolean[] KeyCodePressed = new boolean[120];

     public static boolean IsKeyPressed(int key){
         return KeyCodePressed[key];
     }

    public static void CheckIfButtonMapIsPressed() {
        Input.Key_W = KeyCodePressed[KeyEvent.VK_W];
        Input.Key_S = KeyCodePressed[KeyEvent.VK_S];
        Input.Key_A = KeyCodePressed[KeyEvent.VK_A];
        Input.Key_D = KeyCodePressed[KeyEvent.VK_D];
        Input.Key_Space = KeyCodePressed[KeyEvent.VK_SPACE];

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = true;
    }
}