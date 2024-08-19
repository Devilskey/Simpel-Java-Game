package Interfaces;

import objects.RenderSceneData;

public interface IScene {

    public void UpdateRender();

    public void UpdateGameLogic();

    public RenderSceneData RenderdScene();
}
