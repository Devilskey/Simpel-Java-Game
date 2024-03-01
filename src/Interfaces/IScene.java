package Interfaces;

import objects.Camera;
import objects.RenderSceneData;
import objects.Vector2;

public interface IScene {

    public void UpdateRender();

    public void Update();

    public RenderSceneData RenderdScene();
}
