package Interfaces;

import objects.Camera;
import objects.RenderSceneData;
import objects.Vector2;

public interface IScene {
    public Camera cam = new Camera(new Vector2(0,0));

    public void Update();

    public RenderSceneData RenderdScene();
}
