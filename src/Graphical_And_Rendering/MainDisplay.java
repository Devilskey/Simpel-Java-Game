package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.GameData;
import objects.RenderSceneData;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();

    private long timeLastFrame = System.nanoTime();;

    public MainDisplay(){
        addKeyListener(key);
    }

    public void UpdateDisplay () {
        // System.out.println("FPS: " + GameData.fps);
        SceneManager.SceneLoaded.UpdateRender();
    }

    public void Render(RenderSceneData SceneData){
        BufferStrategy Buffer = this.getBufferStrategy();
        if(Buffer == null){
            createBufferStrategy(1);
            return;
        }
        Graphics graphics = Buffer.getDrawGraphics();
        if(SceneData.img.getHeight() < GameData.WindowSize.GetY() && SceneData.img.getWidth() <  GameData.WindowSize.GetX())
            graphics.drawImage(SceneData.img, (int)SceneData.pos.GetX(), (int)SceneData.pos.GetY(), (int)GameData.WindowSize.GetX(), (int)GameData.WindowSize.GetY(), null);
        else
            graphics.drawImage(SceneData.img, (int)SceneData.pos.GetX(), (int)SceneData.pos.GetY(), null);

        Buffer.show();
        GameData.fps = (int) (1000000000.0  / ( System.nanoTime() - timeLastFrame));
        timeLastFrame = System.nanoTime();
    }
}
