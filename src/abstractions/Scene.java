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


    public abstract void UpdateRender();

    public abstract void UpdateGameLogic();

    public void UpdateEntities() {

    }

    public RenderSceneData RenderdScene() {
        RenderSceneData SceneData = new RenderSceneData();
        SceneData.Pixels = PixelArray;
        SceneData.Entites = Entities;
        SceneData.pos = PositionInScene;
        return SceneData;
    }
}
