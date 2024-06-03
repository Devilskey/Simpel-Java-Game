package Handlers;

import abstractions.Scene;

public class SceneManager {
    public static Scene SceneLoaded;
    public static void SwitchLoadedScene(Scene scene){
        SceneLoaded = scene;
    }

}
