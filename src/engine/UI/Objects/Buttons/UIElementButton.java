package engine.UI.Objects.Buttons;

import Game.Statics.Input;
import engine.Handlers.Peripherals.MouseMotionHandler;
import engine.Interfaces.Action;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.Objects.UIElementPanel;
import engine.UI.Objects.UIElementText;
import engine.UI.StaticUIFunctions;
import engine.UI.enums.UIEnum;
import engine.abstractions.UserInterface;

import java.awt.*;

public class UIElementButton extends UserInterface {
    private UIElementPanel Background;
    private Color ButtonColor;
    private Color ButtonHoverColor;
    private UIElementText Text;
    private Action Function;
    private int Fontsize = 20;
    private Vector2 Position;
    private Scale Margin = new Scale(20,20);
    private Scale TotalSize;
    private boolean ActivateOncePerPress;
    private boolean AlreadyPressed = false;

    public UIElementButton (String content, String ButtonName, Vector2 ButtonPosition, UIEnum LocationOnScreen,Color buttonColor){
        Name = ButtonName;
        Position = ButtonPosition;


        Scale SizeText = StaticUIFunctions.GetTextSize(content, Fontsize);

        Vector2 LocationOnScreenVector = StaticUIFunctions.UIElementPosition(LocationOnScreen);
        Vector2 AddToPosition = new Vector2(LocationOnScreenVector.GetX() - (SizeText.GetWidth() / 2) , LocationOnScreenVector.GetY() - SizeText.GetHeight());

        Position.AddVector(AddToPosition);

        Vector2 TextPosition = new Vector2(Position.GetX() + (Margin.GetWidth() / 2), Position.GetY() + (Margin.GetHeight() / 2));
        Text = new UIElementText(content, TextPosition, Fontsize, 0, UIEnum.topLeft, Name + "-Text");


        ButtonColor = buttonColor;
        Background = new UIElementPanel(Position, TotalSize, ButtonColor,UIEnum.topLeft, ButtonName + "-Background");

        ButtonHoverColor = DimColor(ButtonColor);

    }

    public UIElementButton (String content, String ButtonName, Vector2 ButtonPosition, UIEnum LocationOnScreen, Color buttonColor, Boolean activateOncePerPress){
        Name = ButtonName;
        Position = ButtonPosition;
        System.out.println(Position.GetX() + " X:Y " + Position.GetY() + " Button Text");

        Scale SizeText = StaticUIFunctions.GetTextSize(content, Fontsize);

        Vector2 LocationOnScreenVector = StaticUIFunctions.UIElementPosition(LocationOnScreen);
        Vector2 AddToPosition = new Vector2(LocationOnScreenVector.GetX() - (SizeText.GetWidth() / 2) , LocationOnScreenVector.GetY() - SizeText.GetHeight());

        Position.AddVector(AddToPosition);

        ActivateOncePerPress = activateOncePerPress;

        Vector2 TextPosition = new Vector2(Position.GetX() + (Margin.GetWidth() / 2), Position.GetY() + (Margin.GetHeight() / 2));
        Text = new UIElementText(content, TextPosition, Fontsize, 0, UIEnum.topLeft, Name + "-Text");


        TotalSize = new Scale(SizeText.GetWidth() + Margin.GetWidth(),SizeText.GetHeight() + Margin.GetHeight());

        ButtonColor = buttonColor;
        Background = new UIElementPanel(Position, TotalSize, ButtonColor,  UIEnum.topLeft, ButtonName + "-Background");

        ButtonHoverColor = DimColor(ButtonColor);

    }

    public void SetMargin(int x, int y){
        Margin = new Scale(x, y);
    }

    public void SetFunction (Action newFunction){
        Function = newFunction;
    }

    @Override
    public void RenderUIElement(Graphics graphics) {
        Background.RenderUIElement(graphics);
        Text.RenderUIElement(graphics);

    }

    @Override
    public void Update() {
        super.Update();
        boolean HoversOverButton = HoverCheck();

        if(HoversOverButton) {
            Background.ChangeColor(ButtonHoverColor);
            if (Input.Key_Space && !AlreadyPressed) {
                Function.execute();
                AlreadyPressed = true;
                return;
            }
            if(!Input.Key_Space && AlreadyPressed){
                AlreadyPressed = false;
                return;
            }
        }
        if(!HoversOverButton){
            AlreadyPressed = false;
            Background.ChangeColor(ButtonColor);
        }
    }

    private Color DimColor(Color ColorToDim){
        float Red = ColorToDim.getRed();
        float Blue = ColorToDim.getBlue();
        float Green = ColorToDim.getGreen();

        if(Green + 40 < 250)
            Green += 40;
        else
            Green -= 40;

        if(Blue + 40 < 250)
            Blue += 40;
        else
            Blue -= 40;

        if(Red + 40  < 250)
            Red += 40;
        else
            Red -= 40;

        System.out.println(Red + " :R: " + Green + " :G: " + Blue + " :B");

        return new Color((int)Red, (int)Green, (int)Blue);
    }


    private boolean HoverCheck(){
        Scale MousePosition = MouseMotionHandler.MousePosition;
        float MaxX = Position.GetX() + TotalSize.GetWidth();
        float MaxY = Position.GetY() + TotalSize.GetHeight();

        if(Position.GetX() < MousePosition.GetWidth() && MaxX > MousePosition.GetWidth()){
            if(Position.GetY() < MousePosition.GetHeight() && MaxY > MousePosition.GetHeight()){
                return  true;
            }
        }
        return false;
    }
}
