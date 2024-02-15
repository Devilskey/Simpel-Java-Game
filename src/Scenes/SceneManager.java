package Scenes;

import Handlers.KeyboardHandler;
import Interfaces.IScene;
import objects.RenderSceneData;

public class SceneManager {
    public static IScene SceneLoaded;
    public static KeyboardHandler keyboard;
    public static void SwitchLoadedScene(IScene scene){
        SceneLoaded = scene;
    }


    public static RenderSceneData RenderLoadedScene() {
      return SceneLoaded.RenderdScene();
    }
}
