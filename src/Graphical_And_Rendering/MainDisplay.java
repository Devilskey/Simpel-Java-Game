package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.DebugSettings;
import Statics.GameData;
import objects.RenderSceneData;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();

    public MainDisplay(){
        addKeyListener(key);
    }
    long TimeLastFrame = 0;

    public void UpdateDisplay () {
        SceneManager.SceneLoaded.Update();
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
