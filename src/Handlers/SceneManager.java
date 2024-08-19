package Handlers;

import abstractions.Scene;

public class SceneManager {
    public static Scene SceneLoaded;
    public static void SwitchLoadedScene(Scene scene){
        SceneLoaded = scene;
    }

    public static void UpdateGameLogic (){
        SceneLoaded.UpdateGameLogic();
    }

    public static void UpdateRender (){
      SceneLoaded.UpdateRender();
    }
}
