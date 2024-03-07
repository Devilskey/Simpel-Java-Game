package Scenes.MainScene;

import Interfaces.IScene;
import objects.Camera;
import objects.RenderSceneData;
import objects.Tile;
import objects.SizeObjects.Vector2;

public class MainScene implements IScene {
    private Tile[][] PixelArray;
    Camera cam ;
    private final MainWorldTiles WorldTile;
    public float MovementSpeed = 200;

    public MainScene(){
        WorldTile = new MainWorldTiles();
        Vector2 MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2(128,128), MovementSpeed, (int)MapSize.GetX(), (int)MapSize.GetY());
    }
    public void RenderScene(){
        PixelArray = WorldTile.GetMapTiles((int)cam.pos.GetX(),(int)cam.pos.GetY());
    }

    @Override
    public void Update() {
        cam.MoveCamera();
        RenderScene();
    }

    @Override
    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.Pixels = PixelArray;
        SceneData.pos = cam.pos;
        return SceneData;
    }
}