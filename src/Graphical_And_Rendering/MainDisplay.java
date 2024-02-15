package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Scenes.SceneManager;
import objects.RenderSceneData;
import objects.Vector2;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainDisplay extends Canvas {

    private long TimeLastFrame = 0;
    public static int fps = 0;
    private final Vector2 size;

    public KeyboardHandler key = new KeyboardHandler();

    public MainDisplay(Vector2 size){

        this.size = size;
        addKeyListener(key);

    }

    public void UpdateDisplay () {
        System.out.println("FPS: " +fps);
        SceneManager.SceneLoaded.Update();

    }

    public void Render(RenderSceneData SceneData){
        TimeLastFrame = System.nanoTime();
        BufferStrategy Buffer = this.getBufferStrategy();
        if(Buffer == null){
            createBufferStrategy(3);
            return;
        }
        Graphics graphics = Buffer.getDrawGraphics();
        graphics.drawImage(SceneData.img, (int)SceneData.pos.GetX(), (int)SceneData.pos.GetY(), null);
        Buffer.show();
        fps = (int) (1000000000.0  / ( System.nanoTime() - TimeLastFrame ));

    }
}
