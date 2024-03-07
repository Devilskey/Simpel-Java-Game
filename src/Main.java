import Debuger.DebugWindow;
import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Scenes.MainScene.MainScene;
import Statics.DebugSettings;
import Statics.GameData;
import objects.SizeObjects.Vector2;

import javax.swing.*;


public class Main {
    private static final String title = "Hello world";
    private static final JFrame MainWindow = new JFrame();
    private static MainDisplay display;

    private static final Vector2 ScreenSize = new Vector2(1280, 720);

    public static void main(String[] args)
    {
        SceneManager.SwitchLoadedScene(new MainScene());

        display = new MainDisplay();

        MainWindow.add(display);
        MainWindow.pack();
        MainWindow.setFocusable(true);
        MainWindow.setFocusTraversalKeysEnabled(false);
        MainWindow.setTitle(title + " Fps = " + GameData.fps);
        MainWindow.setSize((int)ScreenSize.GetX(), (int)ScreenSize.GetY());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLocationRelativeTo(null);
        // MainWindow.setResizable(false);
        MainWindow.setVisible(true);
        KeyboardHandler.CheckIfButtonMapIspressed();


        if(DebugSettings.UseDebugWindow) {
            SwingUtilities.invokeLater(DebugWindow::new);
            DebugWindow.log("Window Opend");
        }

        while(MainWindow.isVisible()) {

            KeyboardHandler.CheckIfButtonMapIspressed();
            WindowData();
            GameLoop();
        }
    }
    static void WindowData(){
        GameData.WindowSize.SetHeight(MainWindow.getHeight());
        GameData.WindowSize.SetWidth(MainWindow.getWidth());
        MainWindow.setTitle(title + " Fps = " + GameData.fps);
    }

    static void GameLoop(){
        display.UpdateDisplay();
        display.Render(SceneManager.RenderLoadedScene());
    }
}