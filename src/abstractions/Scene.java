package abstractions;

import Handlers.Physics.ColisionHandler;
import enums.MoveTo;
import objects.Camera;
import objects.RenderSceneData;
import objects.SizeObjects.Vector2;
import objects.Tiles.Tile;

import java.util.ArrayList;

public abstract class Scene {
    public Tile[][] PixelArray;
    public Vector2 PositionInScene = new Vector2(0,0);
    public ArrayList<Entity> Entities = new ArrayList<Entity>();

    public Scene(){
    }

    public void UpdateScene() {
        RenderScene();
        UpdateEntities();
        Update();
    };

    public abstract void Update();

    public abstract void RenderScene();

    public void UpdateEntities() {
        if(Entities == null)
            return;
        ColisionHandler.ResetNearestNPC();
        ColisionHandler.SetMap(PixelArray);
        ColisionHandler.SetEntities(Entities);
        for (Entity entity : Entities) {
            if (entity.CanMove) {
                entity.ObstacleUp = ColisionHandler.CanCollide(entity.Position, MoveTo.Up);
                entity.ObstacleDown = ColisionHandler.CanCollide(entity.Position, MoveTo.Down);
                entity.ObstacleLeft = ColisionHandler.CanCollide(entity.Position, MoveTo.Left);
                entity.ObstacleRight = ColisionHandler.CanCollide(entity.Position, MoveTo.Right);
            }
            entity.Update();
        }
    }

    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.Pixels = PixelArray;
        SceneData.Entites = Entities;
        SceneData.pos = PositionInScene;
        return SceneData;
    }
}
