package Scenes.MainScene;

import Debuger.DebugWindow;
import Interfaces.IScene;
import abstractions.Entity;
import objects.Camera;
import Entities.Player;
import objects.RenderSceneData;
import objects.SizeObjects.Scale;
import objects.Tiles.Tile;
import objects.SizeObjects.Vector2;

public class MainScene implements IScene {
    private Tile[][] PixelArray;
    Camera cam ;
    public Entity[] Entities = new Entity[1];
    private final MainWorldTiles WorldTile;

    public MainScene(){
        WorldTile = new MainWorldTiles();
        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2 (0,0), 200, (int)MapSize.GetWidth() , (int)MapSize.GetHeight());
        Entities[0] = new Player();
    }
    public void RenderScene(){
        PixelArray = WorldTile.GetMapTiles((int)cam.pos.GetX(),(int)cam.pos.GetY());
    }

    @Override
    public void Update() {
        UpdateEntities();
        RenderScene();
    }

    public void UpdateEntities(){
        for (Entity entity : Entities)
            entity.Update();

        cam.MoveCamera();

    }

    @Override
    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.Pixels = PixelArray;
        SceneData.Entites = Entities;
        SceneData.pos = cam.pos;
        return SceneData;
    }
}
