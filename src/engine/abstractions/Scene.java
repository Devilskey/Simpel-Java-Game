package engine.abstractions;

import engine.Audio.AudioHandler;
import engine.Handlers.EntityHandler;
import engine.Objects.Camera;
import engine.UI.UIHandler;
import engine.Objects.RenderSceneData;
import engine.Objects.SizeObjects.Vector2;
import engine.Objects.Tiles.Tile;

public abstract class Scene {
        public Camera cam = new Camera(new Vector2(0,0), true );
        public Tile[][] PixelArray = new Tile[0][0];
        public Vector2 PositionInScene = new Vector2(0,0);
        public EntityHandler Entities = new EntityHandler();
        public UIHandler UI = new UIHandler();
        public AudioHandler SoundList = new AudioHandler();

        public Scene(){

        }

        public abstract void UpdateRender();

        public abstract void UpdateGameLogic();

        public void UIUpdate() {
            UI.Update();
        };

        public RenderSceneData RenderScene() {
            RenderSceneData SceneData = new RenderSceneData();
        SceneData.Pixels = PixelArray;
        SceneData.Entites = Entities.GetList();
        SceneData.pos = PositionInScene;
        SceneData.UIhandler = UI;
        return SceneData;
    }
}
