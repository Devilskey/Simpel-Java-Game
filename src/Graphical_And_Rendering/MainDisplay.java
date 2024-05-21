package Graphical_And_Rendering;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Statics.GameData;
import objects.RenderSceneData;
import objects.UserInterfaces.UserInterfaceObjects;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainDisplay extends Canvas {
    public KeyboardHandler key = new KeyboardHandler();
    private final List<UserInterfaceObjects> uiTextObjects = new ArrayList<>();

    public MainDisplay() {
        addKeyListener(key);
    }

    public void addUITextObject(UserInterfaceObjects uiTextObject) {
        uiTextObjects.add(uiTextObject);
    }

    public void removeUITextObject(UserInterfaceObjects uiTextObject) {
        uiTextObjects.remove(uiTextObject);
    }

    public void clearUITextObjects() {
        uiTextObjects.clear();
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

        Buffer.show();

        GameData.fps = (int) (1000000000.0 / (System.nanoTime() - TimeLastFrame));
        TimeLastFrame = System.nanoTime();
    }

    private void renderUITextObjects(Graphics graphics) {
        uiTextObjects.sort(Comparator.comparingInt(UserInterfaceObjects::getPositionZ));

        for (UserInterfaceObjects uiTextObject : uiTextObjects) {
            uiTextObject.render(graphics);
        }
    }
}
