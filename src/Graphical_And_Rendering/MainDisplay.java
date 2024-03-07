package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
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

    public void UpdateDisplay () {
        SceneManager.SceneLoaded.Update();
    }

    public void Render(RenderSceneData SceneData){
        long timeLastFrame = System.nanoTime();
        BufferStrategy Buffer = this.getBufferStrategy();
        if(Buffer == null){
            createBufferStrategy(1);
            return;
        }
        Graphics graphics = Buffer.getDrawGraphics();
        SceneData.RenderImg(graphics);

        Buffer.show();

        GameData.fps = (int) (1000000000.0  / ( System.nanoTime() - timeLastFrame));
    }
}
