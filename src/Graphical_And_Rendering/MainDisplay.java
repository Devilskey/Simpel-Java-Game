package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.GameData;
import objects.RenderSceneData;
<<<<<<< HEAD
import objects.UserInterfaces.UserInterfaceObjects;
=======
import objects.UserInterfaces.UITexts;
import objects.UserInterfaces.UIImages;
>>>>>>> 12d40f53f73e333f0cf4b9e56a318f643e5a1858

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.ImageObserver;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();
    private List<UserInterfaceObjects> uiTextObjects = new ArrayList<>();

    public MainDisplay() {
        addKeyListener(key);
    }

    public void addUITextObject(UserInterfaceObjects uiTextObject) {
        uiTextObjects.add(uiTextObject);
    }

    long TimeLastFrame = 0;

    public void UpdateDisplay() {
        SceneManager.SceneLoaded.Update();
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

        renderUITextObjects(graphics);
        renderUIImageObjects(graphics);

        Buffer.show();

        renderUITextObjects(graphics);

        GameData.fps = (int) (1000000000.0  / ( System.nanoTime() - TimeLastFrame));
        TimeLastFrame = System.nanoTime();
    }

    private void renderUITextObjects(Graphics g) {
        for (UserInterfaceObjects uiTextObject : uiTextObjects) {
            uiTextObject.render(g);
        }
    }
}