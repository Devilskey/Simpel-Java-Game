package engine.Handlers;

import engine.Debugger.Logger;
import engine.Enums.LogLevel;
import engine.Prefabs.Scene.NewScene.NewScene;
import engine.abstractions.Scene;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SceneManager {
    public static Scene SceneLoaded;
    protected static Map<String, Scene> SceneDictionary = new HashMap<String, Scene>();
    protected static String FirstSceneName = "";
    protected static Scene NoSceneFoundOnFirstLoadScene = new NewScene();

    public static void SwitchLoadedScene(String scene){
        Scene NextScene =  SceneDictionary.get(scene);
        if(NextScene != null) {
            SceneLoaded = NextScene;
            return;
        }
        Logger.Log(LogLevel.Error, "Scene with name: " + scene + "Does not exist!");
    }

    public static void UpdateGameLogic (){

        SceneLoaded.UpdateGameLogic();
        SceneLoaded.UIUpdate();
    }

    public static void UpdateRender (){

      SceneLoaded.UpdateRender();
    }

    public static void AddAvailableScene(String SceneName, Scene scene){
        if(Objects.equals(FirstSceneName, ""))
            FirstSceneName = SceneName;
        SceneDictionary.put(SceneName, scene);
    }

    public static void LoadFirstScene(){
        SceneLoaded = SceneDictionary.get(FirstSceneName);
        if(SceneLoaded == null){
            SceneLoaded = NoSceneFoundOnFirstLoadScene;
        }
    }

    public static void GetFirstScene(){
        SceneDictionary.get(FirstSceneName);
    }
}
