import Demo.CookieClicker.CookieClicker;
import Game.Scenes.MenuScene.MenuScene;
import engine.Debugger.Logger;
import engine.Graphical_And_Rendering.MainDisplay;
import engine.Handlers.Peripherals.KeyboardHandler;
import engine.Handlers.SceneManager;
import engine.Handlers.TickHandler;
import Game.Scenes.CollisionTestScene.CollisionScene;
import Game.Statics.DebugSettings;
import Game.Statics.GameData;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;

import javax.swing.*;

public class Main {
        private static final String title = "Hello world";
        private static final JFrame MainWindow = new JFrame();
        private static MainDisplay display;
        private static final Vector2 ScreenSize = new Vector2(1080, 720);
        private static TickHandler TickHandler;

        public static void main(String[] args) {
                Logger.LoggerInit();
                DebugSettings.StartDebugWindow();
                TickHandler = new TickHandler();
                GameData.WindowSize = new Scale((int) ScreenSize.GetX(), (int) ScreenSize.GetY());

                SceneManager.SwitchLoadedScene(new CookieClicker());

                display = new MainDisplay();

                MainWindow.add(display);
                MainWindow.pack();
                MainWindow.setFocusable(true);
                MainWindow.setFocusTraversalKeysEnabled(false);
                MainWindow.setSize((int) ScreenSize.GetX(), (int) ScreenSize.GetY());
                MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MainWindow.setLocationRelativeTo(null);
                MainWindow.setResizable(true);
                MainWindow.setVisible(true);

                while (MainWindow.isVisible()) {
                        GameLoop();
                        MainWindow.setTitle(title + " Fps = " + GameData.fps + " TICKS PER MS: " + GameData.MS_PER_TICK);

                        KeyboardHandler.CheckIfButtonMapIspressed();

                }
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
