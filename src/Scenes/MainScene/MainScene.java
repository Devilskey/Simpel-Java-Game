package Scenes.MainScene;

import Debuger.DebugWindow;
import Handlers.Physics.ColisionHandler;
import Interfaces.IScene;
import abstractions.Entity;
import enums.MoveTo;
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
        RenderScene();
        UpdateEntities();
    }

    public void UpdateEntities(){
        ColisionHandler.SetMap(PixelArray);
        for (Entity entity : Entities) {
            if(entity.CanMove){
                entity.ObstacleUp = ColisionHandler.CanCollideWithTile(entity.Position, MoveTo.Up);
                entity.ObstacleDown = ColisionHandler.CanCollideWithTile(entity.Position, MoveTo.Down);
                entity.ObstacleLeft = ColisionHandler.CanCollideWithTile(entity.Position, MoveTo.Left);
                entity.ObstacleRight = ColisionHandler.CanCollideWithTile(entity.Position, MoveTo.Right);
            }
            entity.Update();
        }

        cam.MoveWithEntitie(Entities[0].Position);
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
