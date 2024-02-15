import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Graphical_And_Rendering.Scenes.MainScene;
import Graphical_And_Rendering.Scenes.SceneManager;
import Statics.GameData;
import objects.Vector2;

import javax.swing.*;


public class Main {
    private static final String title = "Hello world";
    private static final JFrame MainWindow = new JFrame();
    private static MainDisplay display;

    private static final Vector2 ScreenSize = new Vector2(500, 500);

    public static void main(String[] args)
    {
        SceneManager.SwitchLoadedScene(new MainScene());

        display = new MainDisplay(ScreenSize);

        MainWindow.add(display);
        MainWindow.pack();
        MainWindow.setFocusable(true);
        MainWindow.setFocusTraversalKeysEnabled(false);
        MainWindow.setTitle(title);
        MainWindow.setSize((int)ScreenSize.GetX(), (int)ScreenSize.GetY());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLocationRelativeTo(null);
        MainWindow.setVisible(true);
        KeyboardHandler.CheckIfButtonMapIspressed();

        while(MainWindow.isVisible()) {

            KeyboardHandler.CheckIfButtonMapIspressed();
            WindowData();
            GameLoop();
        }
    }

    static void WindowData(){
        GameData.WindowSize.SetY(MainWindow.getHeight());
        GameData.WindowSize.SetX(MainWindow.getWidth());
    }

    static void GameLoop(){
        display.UpdateDisplay();
        display.Render(SceneManager.RenderLoadedScene());

    }
}