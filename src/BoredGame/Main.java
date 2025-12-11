package BoredGame;
import BoredGame.Scenes.OverWorld.OverWorldScene;
import Statics.DebugSettings;
import Statics.GameData;
import engine.Debugger.Logger;
import engine.Graphical_And_Rendering.MainDisplay;
import engine.Handlers.Peripherals.KeyboardHandler;
import engine.Handlers.SceneManager;
import engine.Handlers.TickHandler;
import engine.Objects.SizeObjects.Scale;

import javax.swing.*;

public class Main {
    private static final JFrame MainWindow = new JFrame();
    private static MainDisplay display;
    private static final Scale ScreenSize = new Scale(640, 360);
    private static TickHandler TickHandler;

    public static void main(String[] args) {
        Logger.LoggerInit();
        DebugSettings.StartDebugWindow();
        TickHandler = new TickHandler();
        GameData.WindowSize = ScreenSize;
        AddScenes();
        SceneManager.LoadFirstScene();

        display = new MainDisplay();

        MainWindow.add(display);
        MainWindow.pack();
        MainWindow.setFocusable(true);
        MainWindow.setFocusTraversalKeysEnabled(false);
        MainWindow.setSize( ScreenSize.GetWidth(), ScreenSize.GetHeight());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLocationRelativeTo(null);
        MainWindow.setResizable(true);
        MainWindow.setVisible(true);

        while (MainWindow.isVisible()) {
            GameLoop();
            MainWindow.setTitle(GameData.Title + " Fps = " + GameData.fps + " TICKS PER MS: " + GameData.MS_PER_TICK);

            KeyboardHandler.CheckIfButtonMapIsPressed();

        }
    }

    private static void AddScenes(){
        // Add the scenes you want to use here to the scene manager
        // SceneManager.AddAvailableScene("CollisionScene", new CollisionScene());
        SceneManager.AddAvailableScene("OverWorld", new OverWorldScene());

    }

    static void GameLoop() {
        SceneManager.UpdateRender();
        display.Render();
        if(TickHandler.timeForNewTick()) {
            SceneManager.UpdateGameLogic();
        }else{
            //TickHandler.TimeForNextTick();
        }
    }
}
