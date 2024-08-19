package Scenes.MainScene;

import Entities.NPC.Villager;
import Handlers.Physics.ColisionHandler;
import abstractions.Scene;
import abstractions.Entity;
import enums.MoveTo;
import objects.Camera;
import Entities.Player;
import objects.SizeObjects.Scale;
import objects.Tiles.Tile;
import objects.SizeObjects.Vector2;

import javax.swing.text.Position;

public class MainScene extends Scene {

    private final MainWorldTiles WorldTile;

    private Camera cam ;

    public MainScene(){
        super();
        WorldTile = new MainWorldTiles();

        Scale MapSize = WorldTile.GetSizeMapPixels();
        cam = new Camera(new Vector2 (0,0),
                200,
                (int)MapSize.GetWidth() ,
                (int)MapSize.GetHeight());

        Entities.add(new Player());
        Entities.add(new Villager(new Vector2(64, 64),
                "src/assets/Scripts/VillagerHenk.txt"));
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

        cam.MoveWithEntitie(Entities.get(0).Position);
        PositionInScene = cam.pos;

    }
}
