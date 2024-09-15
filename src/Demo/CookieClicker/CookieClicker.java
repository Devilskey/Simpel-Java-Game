package Demo.CookieClicker;

import Game.Statics.GameData;
import engine.Audio.AudioObject;
import engine.Objects.Camera;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.Objects.Buttons.UIElementButton;
import engine.UI.Objects.Buttons.UIElementImageButton;
import engine.UI.Objects.UIElementImage;
import engine.UI.Objects.UIElementPanel;
import engine.UI.Objects.UIElementText;
import engine.UI.enums.UIEnum;
import engine.abstractions.Scene;

import java.awt.*;

public class CookieClicker extends Scene {

    private int CookiesClickedCounter = 0;
    private  UIElementText CookiesClicked;
    private int maxCookieSizeIncrease = 10;
    private int CookieSizeIncreasedBy = 0;
    private String CookiePath = "src/Demo/CookieClicker/Assets/Cookie.png";
    private UIElementImageButton ClickMe;
    public final Scale SizeCookie = new Scale(GameData.WindowSize.GetHeight() - 300, GameData.WindowSize.GetHeight() - 300);

    public CookieClicker(){
        super();
        SetupUI();
        SetupSound();
    }

    private void SetupSound(){
       SoundList.Add("Click",  new AudioObject("src/Demo/CookieClicker/Assets/click.wav"));
    }

    private void SetupUI(){
        UI.add(new UIElementPanel(new Vector2(0,0), GameData.WindowSize, Color.white, "Background"));

        CookiesClicked = new UIElementText("Cookies Clicked:", new Vector2(0,0),30, 1 , UIEnum.topCenter, "Cookies");

        //UIElementButton ClickMe = new UIElementButton("Click Me please", "BUTTON", new Vector2(0,0), UIEnum.midCenter, Color.white, true);
        Vector2 CookiePos = new Vector2(((float) GameData.WindowSize.GetWidth() / 2) - ((float) SizeCookie.GetWidth() / 2),
                                    ((float) GameData.WindowSize.GetHeight() / 2)  - ((float) SizeCookie.GetHeight() / 2));

        ClickMe = new UIElementImageButton(CookiePath, "Cookie", CookiePos, SizeCookie, UIEnum.topLeft);
        ClickMe.SetIsImageCentered(true);

        //UIElementImage Image = new UIElementImage(CookiePos, SizeCookie, "src/Demo/CookieClicker/Assets/Cookie.png","TestImage");

        ClickMe.SetFunction(() -> {
            SoundList.Get("Click").PlaySound();
            this.CookiesClickedCounter += 1;
            this.CookieSizeIncreasedBy += 1;

            this.ClickMe.addHeight(5);
            this.ClickMe.addWidth(5);
            System.out.println(this.CookieSizeIncreasedBy);
            if(this.CookieSizeIncreasedBy >= this.maxCookieSizeIncrease){
                this.ClickMe.ChangeSize( new Scale(GameData.WindowSize.GetHeight() - 300, GameData.WindowSize.GetHeight() - 300));
                this.ClickMe.ChangePosition( new Vector2(
                        ((float) GameData.WindowSize.GetWidth() / 2) - ((float) SizeCookie.GetWidth() / 2),
                        ((float) GameData.WindowSize.GetHeight() / 2)  - ((float) SizeCookie.GetHeight() / 2)));

                this.CookieSizeIncreasedBy = 0;
                System.out.println("Cookie Size Reset");

            }
        });
        UI.add(ClickMe);
        UI.add(CookiesClicked);
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
        CookiesClicked.TextContent = "Cookies Clicked: " + CookiesClickedCounter;
        UI.updateElementByName("Cookies", CookiesClicked);
    }
}
