package Scenes.MainScene;

import Entities.Villager;
import Handlers.KeyboardHandler;
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
    public Entity[] Entities = new Entity[2];
    private final MainWorldTiles WorldTile;

    public MainScene(){
        WorldTile = new MainWorldTiles();
        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2 (0,0), 200, (int)MapSize.GetWidth() , (int)MapSize.GetHeight());
        Entities[0] = new Player();
        Entities[1] = new Villager(new Vector2(64, 64), "src/assets/Scripts/VillagerHenk.txt");
    }

    @Override
    public void UpdateRender() {
        PixelArray = WorldTile.GetMapTiles(cam.pos.GetX(),cam.pos.GetY());
    }

    @Override
    public void UpdateGameLogic() {
        ColisionHandler.ResetNearestNPC();
        ColisionHandler.SetMap(PixelArray);
        ColisionHandler.SetEntities(Entities);
        for (Entity entity : Entities) {
            if(entity.CanMove){
                entity.ObstacleUp = ColisionHandler.CanCollide(entity.Position, MoveTo.Up);
                entity.ObstacleDown = ColisionHandler.CanCollide(entity.Position, MoveTo.Down);
                entity.ObstacleLeft = ColisionHandler.CanCollide(entity.Position, MoveTo.Left);
                entity.ObstacleRight = ColisionHandler.CanCollide(entity.Position, MoveTo.Right);
            }
            entity.Update();
            if(entity instanceof Player)
                ((Player) entity).NearNPC = ColisionHandler.GetNearestNPC();
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
