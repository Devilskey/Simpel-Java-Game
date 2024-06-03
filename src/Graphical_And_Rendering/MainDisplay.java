package Graphical_And_Rendering;

import Handlers.Peripherals.KeyboardHandler;
import Handlers.Peripherals.MouseInputHandler;
import Handlers.Peripherals.MouseMotionHandler;
import Handlers.SceneManager;
import Statics.GameData;
import objects.RenderSceneData;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();
    public MouseInputHandler mouseInput = new MouseInputHandler();
    public MouseMotionHandler mouseMotion = new MouseMotionHandler();

    public MainDisplay(){
        addKeyListener(key);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseMotion);

    }
    long TimeLastFrame = 0;

    public void UpdateDisplay () {
        SceneManager.SceneLoaded.UpdateScene();
    }

    public void Render(){
        if(TimeLastFrame == 0)
            TimeLastFrame = System.nanoTime();
        RenderSceneData SceneData = SceneManager.SceneLoaded.RenderdScene();
        BufferStrategy Buffer = this.getBufferStrategy();

        if(Buffer == null){
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = Buffer.getDrawGraphics();
        SceneData.RenderImg(graphics);
        SceneData.RenderEntities(graphics);
        Buffer.show();

        GameData.fps = (int) (1000000000.0  / ( System.nanoTime() - TimeLastFrame));
        TimeLastFrame = System.nanoTime();

    }
}
