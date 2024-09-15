package Game.Scenes.MenuScene;

import Game.Scenes.CollisionTestScene.CollisionScene;
import Game.Statics.GameData;
import engine.Handlers.SceneManager;
import engine.Objects.Camera;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.Objects.Buttons.UIElementButton;
import engine.UI.Objects.UIElementPanel;
import engine.UI.Objects.UIElementText;
import engine.UI.enums.UIEnum;
import engine.abstractions.Scene;

import java.awt.*;

public class MenuScene extends Scene {

    private Camera cam ;
    private int Count;

    public MenuScene(){
        super();
        cam = new Camera(new Vector2(0,0), true );
        SetupUI();
    }

    private void SetupUI(){
        UI.add(new UIElementPanel(new Vector2(0,0), GameData.WindowSize, Color.white, "Background"));
        UI.add(new UIElementPanel(new Vector2(0,0), new Scale( GameData.WindowSize.GetWidth(), 50), Color.BLACK, UIEnum.topLeft,"Title-Background"));

        UIElementText Title = new UIElementText("TEST MENU THE GAME", new Vector2(0,0),30, 1 , UIEnum.topCenter, "Title");
        Title.SetColor(Color.WHITE);

        UIElementButton Start = new UIElementButton("Start Game", "BUTTON", new Vector2(100,200), UIEnum.midCenter ,Color.red);
        Start.SetFunction(() -> {
            System.out.println("Starting Game");
            SceneManager.SwitchLoadedScene(new CollisionScene());
        });

        UIElementButton Exit = new UIElementButton("Start Game", "BUTTON", new Vector2(100,300),UIEnum.midCenter, Color.red);
        Exit.SetFunction(() -> {

            System.out.println("Stopping Game");

            System.exit(1);
        });

        UI.add(Title);
        UI.add(Start);
        UI.add(Exit);

    }

    @Override
    public void UpdateRender() {
    }

    @Override
    public void UpdateGameLogic() {


    }

    @Override
    public void UIUpdate() {
        super.UIUpdate();

    }
}
