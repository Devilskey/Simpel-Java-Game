import Debuger.DebugWindow;
import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Scenes.MainScene.MainScene;
import Statics.DebugSettings;
import Statics.GameData;
import objects.SizeObjects.Vector2;
import objects.UserInterfaces.UserInterfaceObjects;

import java.awt.*;
import javax.swing.*;


public class Main {
    private static final String title = "Hello world";
    private static final JFrame MainWindow = new JFrame();
    private static MainDisplay display;
    private static final Vector2 ScreenSize = new Vector2(500, 500);

    public static void main(String[] args) {
        DebugSettings.StartDebugWindow();

        SceneManager.SwitchLoadedScene(new MainScene());

        display = new MainDisplay();
        UserInterfaceObjects textObject_One = new UserInterfaceObjects(
                "TextObjectOne", 200, 50, 50, 50, 5,
                "Hello, World!", Color.BLACK, "solid", Color.RED, 2,
                Color.WHITE, 20, "Arial", true, false
        );
        display.addUITextObject(textObject_One);

        MainWindow.add(display);
        MainWindow.pack();
        MainWindow.setFocusable(true);
        MainWindow.setFocusTraversalKeysEnabled(false);
        MainWindow.setTitle(title + " Fps = " + GameData.fps);
        MainWindow.setSize((int) ScreenSize.GetX(), (int) ScreenSize.GetY());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLocationRelativeTo(null);
        MainWindow.setResizable(true);
        MainWindow.setVisible(true);

        while (MainWindow.isVisible()) {
            GameLoop();
            KeyboardHandler.CheckIfButtonMapIspressed();
            KeyboardHandler.CheckButtonState();
        }
    }

    static void GameLoop(){
        display.UpdateDisplay();
        display.Render();
    }
}