package engine.UI.Objects;

import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.UIElementLocation;
import engine.UI.enums.UIEnum;
import engine.abstractions.UserInterface;

import java.awt.*;

public class UIElementPanel extends UserInterface {
    private Vector2 Position;
    private Scale Size;
    private Color PanelColor;
    private UIEnum Location;

    public UIElementPanel (Vector2 position, Scale size, Color panelColor, String name){
        Position = position;
        Size = size;
        PanelColor = panelColor;
        Name = name;
    }

    public UIElementPanel (Vector2 position, Scale size, Color panelColor, UIEnum locationOnScreen, String name){
        Position = position;
        Size = size;
        PanelColor = panelColor;
        Name = name;
        if (locationOnScreen == null)
            Location = UIEnum.topLeft;
        else
            Location = locationOnScreen;
        Position.AddVector(UIElementPosition());
        System.out.println(Position.GetX() + " X:Y " + Position.GetY());
    }

    public void ChangeSize(Scale size){
        Size = size;
    }

    public void ChangeColor(Color color){
        PanelColor = color;
    }

    public void setWidth(int width){
        Size.SetWidth(width);
    }
    public void setHeight(int height){
        Size.SetHeight(height);
    }

    @Override
    public void RenderUIElement(Graphics graphics) {
        Color OldColor = graphics.getColor();
        graphics.setColor(PanelColor);

        graphics.fillRect((int)Position.GetX(), (int)Position.GetY(), Size.GetWidth(), Size.GetHeight());
        graphics.setColor(OldColor);
    }

    private Vector2 UIElementPosition() {
        Vector2 UIposition = new Vector2(0,0);
        switch (Location){
            case midLeft -> UIposition = UIElementLocation.MidLeft();
            case midCenter -> UIposition = UIElementLocation.MidCenter();
            case midRight ->  UIposition = UIElementLocation.MidRight();
            case topCenter -> UIposition = UIElementLocation.TopCenter();
            case topLeft ->  UIposition = UIElementLocation.TopLeft();
            case topRight -> UIposition = UIElementLocation.TopRight();
            case bottomCenter -> UIposition = UIElementLocation.BottomCenter();
            case bottomLeft -> UIposition = UIElementLocation.BottomLeft();
            case bottomRight -> UIposition = UIElementLocation.BottomRight();
        }
        return UIposition;
    }
}
