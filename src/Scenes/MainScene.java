package Scenes;

import Graphical_And_Rendering.MainDisplay;
import Handlers.KeyboardHandler;
import Interfaces.IScene;
import objects.RenderSceneData;
import objects.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class MainScene implements IScene {

    BufferedImage SceneImg = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
    BufferedImage Logo;
    public float MovementSpeed = 225;
    public MainScene(){
        try {
            Logo = ImageIO.read(new File("src/assets/logo.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }

        SceneImg.createGraphics();
    }

    public void RenderScene(){
        Graphics scenegraphics = SceneImg.getGraphics();
        scenegraphics.drawImage(Logo, 0,0, null);
    }

    @Override
    public void Update() {
        RenderScene();
        if(KeyboardHandler.Key_A)
            cam.pos.addX(MovementSpeed / MainDisplay.fps);
        if(KeyboardHandler.Key_D)
            cam.pos.addX(-(float) MovementSpeed / MainDisplay.fps);
        if(KeyboardHandler.Key_S)
            cam.pos.addY(-MovementSpeed / MainDisplay.fps);
        if(KeyboardHandler.Key_W)
            cam.pos.addY(MovementSpeed / MainDisplay.fps);
    }
    @Override
    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.img = SceneImg;
        SceneData.pos = cam.pos;
        return SceneData;
    }
}
