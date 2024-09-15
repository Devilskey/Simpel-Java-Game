package engine.Handlers;

import engine.abstractions.Scene;

public class SceneManager {
    public static Scene SceneLoaded;
    public static void SwitchLoadedScene(Scene scene){
        SceneLoaded = scene;
    }

    public static void UpdateGameLogic (){
        SceneLoaded.UpdateGameLogic();
        SceneLoaded.UIUpdate();
    }

    public static void UpdateRender (){
      SceneLoaded.UpdateRender();
    }
}
