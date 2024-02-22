package Scenes;

import Handlers.KeyboardHandler;
import Handlers.SceneManager;
import Interfaces.IScene;
import Scenes.MainScene.MainScene;
import Statics.GameData;
import objects.Camera;
import objects.RenderSceneData;
import objects.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplashScene implements IScene {
    BufferedImage SceneImg = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
    Camera cam;
    BufferedImage Logo;

    private String PressSpace = "Press Space";

    public SplashScene (){
        cam = new Camera(new Vector2(GameData.WindowSize.GetX() / 2,GameData.WindowSize.GetY() / 2), 0, 0, 0);
        try {
            Logo = ImageIO.read(new File("src/assets/logo.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void Update() {
        SceneImg = new BufferedImage((int)GameData.WindowSize.GetX(), (int)GameData.WindowSize.GetY(), BufferedImage.TYPE_INT_RGB);

        RenderScene();
    }

    public void RenderScene(){
        int Width = (int)GameData.WindowSize.GetX() / 2;
        int height = (int)GameData.WindowSize.GetY() / 2;
        int LogoSize = 500 * ((int)GameData.WindowSize.GetY() / 500);

        Graphics scenegraphics = SceneImg.getGraphics();
        scenegraphics.setColor(Color.white);
        scenegraphics.fillRect(0,0, (int)GameData.WindowSize.GetX() , (int)GameData.WindowSize.GetY());
        scenegraphics.drawImage(Logo, Width - (LogoSize / 2), height - (LogoSize / 2), LogoSize, LogoSize, null);
        scenegraphics.setColor(Color.black);
        scenegraphics.drawString(PressSpace, Width - 20, (int)(height * 1.5f) );

        if(KeyboardHandler.Key_Space){
            SceneManager.SwitchLoadedScene(new MainScene());
        }
    }

    @Override
    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.img = SceneImg;
        SceneData.pos = cam.pos;
        return SceneData;
    }
}
