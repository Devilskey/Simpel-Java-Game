import Graphical_And_Rendering.MainDisplay;
import Handlers.Peripherals.KeyboardHandler;
import Handlers.Peripherals.MouseInputHandler;
import Handlers.SceneManager;
import Handlers.TickHandler;
import Scenes.MainScene.MainScene;
import Scenes.TestScene.BlankScene;
import Statics.DebugSettings;
import Statics.GameData;
import enums.LogLevel;
import objects.SizeObjects.Vector2;

import java.awt.*;
import javax.swing.*;

public class Main {
        private static final String title = "Hello world";
        private static final JFrame MainWindow = new JFrame();
        private static MainDisplay display;
        private static final Vector2 ScreenSize = new Vector2(500, 500);
        private static TickHandler TickHandler = new TickHandler();

        public static void main(String[] args) {
                DebugSettings.StartDebugWindow();

                SceneManager.SwitchLoadedScene(new MainScene());

                display = new MainDisplay();

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

        static void GameLoop() {
                SceneManager.UpdateRender();
                display.Render();

                if(TickHandler.timeForNewTick()) {
                        SceneManager.UpdateGameLogic();
                }else{
                        TickHandler.TimeForNextTick();
                }
        }
}
