import Graphical_And_Rendering.MainDisplay;
import Scenes.MainScene;
import Scenes.SceneManager;
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
        MainWindow.setResizable(false);
        MainWindow.setVisible(true);

        while(MainWindow.isVisible())
            GameLoop();
    }

    static void GameLoop(){
        display.UpdateDisplay();
        display.Render(SceneManager.RenderLoadedScene());

    }
}