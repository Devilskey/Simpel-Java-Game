package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Graphical_And_Rendering.Scenes.SceneManager;
import Statics.GameData;
import objects.RenderSceneData;
import objects.Vector2;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainDisplay extends Canvas {
    public static int PixelSize = 64;
    private final Vector2 size;
    public KeyboardHandler key = new KeyboardHandler();

    public MainDisplay(Vector2 size){
        this.size = size;
        addKeyListener(key);
    }

    public void UpdateDisplay () {
        // System.out.println("FPS: " + GameData.fps);
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
        if(SceneData.img.getHeight() < GameData.WindowSize.GetY() && SceneData.img.getWidth() <  GameData.WindowSize.GetX())
            graphics.drawImage(SceneData.img, (int)SceneData.pos.GetX(), (int)SceneData.pos.GetY(), (int)GameData.WindowSize.GetX(), (int)GameData.WindowSize.GetY(), null);
        else
            graphics.drawImage(SceneData.img, (int)SceneData.pos.GetX(), (int)SceneData.pos.GetY(), null);
        Buffer.show();
        GameData.fps = (int) (1000000000.0  / ( System.nanoTime() - timeLastFrame));

    }
}
