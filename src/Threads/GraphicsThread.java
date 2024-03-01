package Threads;

import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.GameData;
import com.sun.tools.javac.Main;
import objects.Vector2;

import javax.swing.*;

public class GraphicsThread extends Thread{
    private static final JFrame MainWindow = new JFrame();
    private static final String title = "Hello world";
    private static final Vector2 ScreenSize = new Vector2(1280, 720);
    private static MainDisplay display;

    public void run(){
        display = new MainDisplay();

        MainWindow.add(display);
        MainWindow.pack();
        MainWindow.setFocusable(true);
        MainWindow.setFocusTraversalKeysEnabled(false);
        MainWindow.setTitle(title);
        MainWindow.setSize((int)ScreenSize.GetX(), (int)ScreenSize.GetY());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLocationRelativeTo(null);
        // MainWindow.setResizable(false);
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
