package engine.Graphical_And_Rendering;

import engine.Handlers.Peripherals.KeyboardHandler;
import engine.Handlers.Peripherals.MouseInputHandler;
import engine.Handlers.Peripherals.MouseMotionHandler;
import engine.Handlers.SceneManager;
import Game.Statics.GameData;
import engine.Objects.RenderSceneData;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();
    public MouseInputHandler mouseInput = new MouseInputHandler();
    public MouseMotionHandler mouseMotion = new MouseMotionHandler();

    public MainDisplay() {
        addKeyListener(key);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseMotion);

    }

    long TimeLastFrame = 0;



    public void UpdateGame() {

    }

    public void Render() {
        if (TimeLastFrame == 0)
            TimeLastFrame = System.nanoTime();
        RenderSceneData SceneData = SceneManager.SceneLoaded.RenderdScene();

        BufferStrategy Buffer = this.getBufferStrategy();
        if (Buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = Buffer.getDrawGraphics();
        SceneData.RenderImg(graphics);
        SceneData.RenderEntities(graphics);
        SceneData.RenderUI(graphics);

        Buffer.show();

        if(GameData.HighestFPSCount < GameData.fps){
            GameData.HighestFPSCount = GameData.fps;
        }

        GameData.fps = (int) (1000000000.0 / (System.nanoTime() - TimeLastFrame));
        TimeLastFrame = System.nanoTime();
    }
}