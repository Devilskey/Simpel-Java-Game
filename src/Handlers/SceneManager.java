package Handlers;

import Interfaces.IScene;
import objects.RenderSceneData;

public class SceneManager {
    public static IScene SceneLoaded;
    public static void SwitchLoadedScene(IScene scene){
        SceneLoaded = scene;
    }

}
