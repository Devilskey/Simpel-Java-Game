package engine.UI.Objects;

import Game.Statics.GameData;
import engine.UI.StaticUIFunctions;
import engine.UI.UIElementLocation;
import engine.UI.enums.UIEnum;
import engine.abstractions.UserInterface;
import engine.Objects.SizeObjects.Vector2;

import java.awt.*;

public class UIElementText extends UserInterface {

    public String TextContent = "";
    private int FontSize = 18;
    private int FontType = 0;
    private Font TextFont;
    private UIEnum Location;
    private Color TextColor;

    public UIElementText(String content, int fontSize, UIEnum locationOnScreen, String TextName){
        FontSize = fontSize;
        TextContent = content;
        Name = TextName;
        if (locationOnScreen == null)
            Location = UIEnum.topLeft;
        else
            Location = locationOnScreen;

    }

    public UIElementText(String content, Vector2 position, int fontSize, int fontType,  UIEnum locationOnScreen, String TextName) {
        TextContent = content;
        Position = position;

        FontSize = fontSize;
        FontType = fontType;
        Name = TextName;
        if (locationOnScreen == null)
            Location = UIEnum.topLeft;
        else
            Location = locationOnScreen;

        Position.AddVector(StaticUIFunctions.UIElementPosition(Location));
        Vector2 CenterText = StaticUIFunctions.UIElementTextPosition(Location, content, fontSize, fontType);
        System.out.println(CenterText.GetX() + " X:Y " + CenterText.GetY() + " POS");
        Position.AddVector(CenterText);
    }


    public UIElementText(String content, Vector2 position, Font NewFont,  UIEnum locationOnScreen, String TextName) {
        TextContent = content;
        Position = position;
        TextFont = NewFont;
        Name = TextName;
        if (locationOnScreen == null)
            Location = UIEnum.topLeft;
        else
            Location = locationOnScreen;
        Position.AddVector(StaticUIFunctions.UIElementPosition(Location));
        Position.AddVector(StaticUIFunctions.UIElementTextPosition(Location, TextContent, FontSize, 0));
    }


    public void SetColor(Color color){
        TextColor = color;
    }

    @Override
    public void RenderUIElement(Graphics graphics) {
        Font OldFont = graphics.getFont();
        if(TextFont == null) {
            TextFont = new Font(GameData.FontName, FontType, FontSize);
        }
        Color OldColor = graphics.getColor();
        if(TextColor == null){
            TextColor = OldColor;
        }

        graphics.setFont(TextFont);
        graphics.setColor(TextColor);
        graphics.drawString(TextContent, (int) Position.GetX(), (int) (Position.GetY() + graphics.getFontMetrics().getAscent()));
        graphics.setFont(OldFont);
        graphics.setColor(OldColor);

    }


}
