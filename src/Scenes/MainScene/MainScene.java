package Scenes.MainScene;

import Interfaces.IScene;
import Statics.GameData;
import objects.Camera;
import objects.RenderSceneData;
import objects.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainScene implements IScene {

    private final int SceneHeight = 4992;
    private final int SceneWidth = 4992;
    private int[][] PixelArray;
    BufferedImage SceneImg = new BufferedImage(SceneWidth, SceneHeight, BufferedImage.TYPE_INT_RGB);
    BufferedImage Logo;
    BufferedImage tileMapImg;
    public boolean MoveCam;
    public boolean MoveImage;
    private final Camera cam;
    private MainWorldTiles WorldTile;
    public float MovementSpeed = 5;

    public MainScene(){
        PixelArray = new int[SceneHeight / GameData.PixelSize][SceneWidth / GameData.PixelSize];

        cam = new Camera(new Vector2(0,0), MovementSpeed, SceneWidth, SceneHeight);
        try {
            tileMapImg = ImageIO.read(new File("src/assets/test/WorstSpriteSheetEver.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        WorldTile = new MainWorldTiles();
        SceneImg.createGraphics();
        
        // Please DONT PUT THIS LINE IN THE UPDATE YES IT WILL FUCK EVERYTHING UP
        // FPS will go from between 10.000 / 3000 to 700/ 400
        WorldTile.DrawMap(SceneImg);
    }
    @Override
    public void UpdateRender(){
        WorldTile.DrawAnimationMap(SceneImg);
    }

    @Override
    public void Update() {
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
