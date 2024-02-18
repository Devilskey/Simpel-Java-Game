package Graphical_And_Rendering.Scenes;

import Graphical_And_Rendering.MainDisplay;
import Graphical_And_Rendering.TileMapHandler;
import Interfaces.IScene;
import Statics.TileSetData;
import objects.Camera;
import objects.RenderSceneData;
import objects.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainScene implements IScene {

    private final int SceneHeight = 5000;
    private final int SceneWidth = 5000;
    private int[][] PixelArray;
    BufferedImage SceneImg = new BufferedImage(5000, 5000, BufferedImage.TYPE_INT_RGB);
    BufferedImage Logo;
    Camera cam ;
    public float MovementSpeed = 120;

    public MainScene(){
        PixelArray = new int[SceneHeight / MainDisplay.PixelSize][SceneHeight / MainDisplay.PixelSize];

        cam = new Camera(new Vector2(0,0), MovementSpeed);
        try {
            Logo = ImageIO.read(new File("src/assets/test/WorstSpriteSheetEver.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        TileMapHandler.LoadTileMapToTileData(Logo);

        SceneImg.createGraphics();
       // GiveMeCOLOR();
        RandomTileUse();
    }

    void GiveMeCOLOR() {
        Graphics scenegraphics = SceneImg.getGraphics();
        Random rand = new Random();
        for (int i = 1; i < PixelArray.length; i++) {
            for (int j = 1; j < PixelArray.length; j++) {
                scenegraphics.setColor(new Color( rand.nextInt(255), rand.nextInt(255),  rand.nextInt(255)));
                scenegraphics.fillRect(i * MainDisplay.PixelSize, j * MainDisplay.PixelSize, MainDisplay.PixelSize, MainDisplay.PixelSize);
            }
        }
    }

    void RandomTileUse() {
        Graphics scenegraphics = SceneImg.getGraphics();
        Random rand = new Random();
        for (int i = 1; i < PixelArray.length; i++) {
            for (int j = 1; j < PixelArray.length; j++) {
                scenegraphics.drawImage(TileMapHandler.Titlemap[rand.nextInt(TileMapHandler.Titlemap.length)], i * MainDisplay.PixelSize, j * MainDisplay.PixelSize, MainDisplay.PixelSize, MainDisplay.PixelSize, null);
            }
        }
    }

    public void RenderScene(){
       // Graphics scenegraphics = SceneImg.getGraphics();
       // scenegraphics.drawImage(TileSetData.Titlemap[0], 32, 32, 32, 32, null);
      //  scenegraphics.drawImage(TileSetData.Titlemap[1], 64, 64, 32, 32, null);
      //  scenegraphics.drawImage(TileSetData.Titlemap[2], 96, 96, 32, 32,null);
      //  scenegraphics.drawImage(TileSetData.Titlemap[3], 128, 128, 32, 32,null);

    }

    @Override
    public void Update() {
        RenderScene();
        cam.MoveCamera();
    }

    @Override
    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.img = SceneImg;
        SceneData.pos = cam.pos;
        return SceneData;
    }
}
