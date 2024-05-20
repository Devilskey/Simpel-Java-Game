package Handlers;
import abstractions.Entity;
import enums.KeyState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.Enumeration;

public class KeyboardHandler implements KeyListener {
    static boolean[] KeyCodePressed = new boolean[120];

    public static Boolean Key_W = false;
    public static Boolean Key_S = false;
    public static Boolean Key_A = false;
    public static Boolean Key_D = false;
    public static Boolean Key_Space = false;

    int i = 0;

    public static boolean Button_Spacebar = false;

    static KeyState[] Keys = new KeyState[120];

    public static void CheckIfButtonMapIspressed() {
        Key_W = KeyCodePressed[KeyEvent.VK_W];
        Key_S = KeyCodePressed[KeyEvent.VK_S];
        Key_A = KeyCodePressed[KeyEvent.VK_A];
        Key_D = KeyCodePressed[KeyEvent.VK_D];
        Key_Space = KeyCodePressed[KeyEvent.VK_SPACE];

        Button_Spacebar = (Keys[KeyEvent.VK_SPACE] == KeyState.JustPressed);
    }

    public static void CheckButtonState(){
        if(Button_Spacebar)
            Keys[KeyEvent.VK_SPACE] = KeyState.AlreadyPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = false;
        if(Keys[e.getKeyCode()] == KeyState.AlreadyPressed){
            System.out.println(i);
        }

        Keys[e.getKeyCode()] = KeyState.NotPressed;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyCodePressed[e.getKeyCode()] = true;
        if(Keys[e.getKeyCode()] != KeyState.AlreadyPressed)
            Keys[e.getKeyCode()] = KeyState.JustPressed;

    }
}