package Game.Scenes.MainScene;

import Game.Entities.NPC.Villager;
import engine.Handlers.Physics.CollisionHandler;
import engine.abstractions.Scene;
import engine.abstractions.Entity;
import engine.Enums.MoveTo;
import engine.Objects.Camera;
import Game.Entities.Player;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;

public class MainScene extends Scene {

    private final MainWorldTiles WorldTile;

    private Camera cam ;

    public MainScene(){
        super();
        WorldTile = new MainWorldTiles();

        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2 (0,0),
                false);

        Entities.add(new Player(64, 64));
        Entities.add(new Villager(new Vector2(64, 64),
                "src/assets/Scripts/VillagerHenk.txt"));
    }

    @Override
    public void UpdateRender() {
        PixelArray = WorldTile.GetMapTiles(cam.pos.GetX(),cam.pos.GetY());
    }

    @Override
    public void UpdateGameLogic() {
        CollisionHandler.ResetNearestNPC();
        CollisionHandler.SetMap(PixelArray);
        CollisionHandler.SetEntities(Entities);
        for (Entity entity : Entities) {
            if(entity.CanMove){
                entity.ObstacleUp = CollisionHandler.CanCollide(entity.Position, MoveTo.Up);
                entity.ObstacleDown = CollisionHandler.CanCollide(entity.Position, MoveTo.Down);
                entity.ObstacleLeft = CollisionHandler.CanCollide(entity.Position, MoveTo.Left);
                entity.ObstacleRight = CollisionHandler.CanCollide(entity.Position, MoveTo.Right);
            }
            entity.Update();
            if(entity instanceof Player)
                ((Player) entity).NearNPC = CollisionHandler.GetNearestNPC();
        }

        cam.MoveWithEntitie(Entities.get(0).Position);
        PositionInScene = cam.pos;

    }

    @Override
    public void UIUpdate() {

    }
}
