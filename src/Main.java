import Graphical_And_Rendering.MainDisplay;
import Scenes.MainScene.MainScene;
import Scenes.SplashScene;
import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.GameData;
import Threads.GameThread;
import Threads.GraphicsThread;
import objects.Vector2;

import javax.swing.*;


public class Main {
    static GraphicsThread graphics = new GraphicsThread();
    static GameThread game = new GameThread();

    public static void main(String[] args)
    {
        SceneManager.SwitchLoadedScene(new MainScene());
        graphics.start();
        game.start();

        while(true) {
            KeyboardHandler.CheckIfButtonMapIspressed();
        }
    }
}