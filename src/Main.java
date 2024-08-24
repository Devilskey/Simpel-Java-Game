import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Scenes.MainScene.MainScene;
import Statics.DebugSettings;
import Statics.GameData;
import objects.SizeObjects.Vector2;
import objects.UserInterfaces.UITexts;
import objects.UserInterfaces.UIImages;

import javax.swing.*;

public class Main {
        private static final String title = "Hello world";
        private static final JFrame MainWindow = new JFrame();
        private static MainDisplay display;
        private static final Vector2 ScreenSize = new Vector2(500, 500);
        private static final int currentHealth = 100; // HERE FOR TESTING/CHECKING
        private static final int currentRuby = 69; // HERE FOR TESTING/CHECKING

        public static void main(String[] args) {
                DebugSettings.StartDebugWindow();

                SceneManager.SwitchLoadedScene(new MainScene());

                display = new MainDisplay();

                UITexts uiTxtObjHealth = new UITexts(
                                "TextObject_Health", 240, 50, 0, 0, 6,
                                "HP | " + currentHealth, "none", "none", "none", 2,
                                "#ff4422", 32, "Arial", true, false);

                display.addUITextObject(uiTxtObjHealth);

                UIImages uiImgObjRuby = new UIImages(
                                "ImageObject_Ruby", 64, 64, 0, 40, 4,
                                "src/assets/UserInterface/ruby.png",
                                "none", "none", 1,
                                false);
                display.addUIImageObject(uiImgObjRuby);

                UITexts uiTxtObjRubyCount = new UITexts(
                        "TextObject_RubyCount", 240, 64, 64, 56, 4,
                        " "+currentRuby, "none", "none", "none", 2,
                        "#ff0000", 32, "Arial", true, false);

                display.addUITextObject(uiTxtObjRubyCount);

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
                display.UpdateDisplay();
                display.Render();
        }
}
