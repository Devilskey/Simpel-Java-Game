package engine.UI.Objects;

import engine.Graphical_And_Rendering.ImageHandler;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.UIElementLocation;
import engine.UI.enums.UIEnum;
import engine.abstractions.UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIElementImage extends UserInterface {
    private Scale Size;
    private UIEnum Location;
    private BufferedImage Image;

    public UIElementImage (Vector2 position, Scale size, String ImagePath, String name){
        Position = position;
        Size = size;
        Name = name;
        Image = ImageHandler.GetImage(ImagePath);
    }

    public UIElementImage (Vector2 position, Scale size,String ImagePath, UIEnum locationOnScreen, String name){
        Position = position;
        Size = size;
        Name = name;
        Image = ImageHandler.GetImage(ImagePath);
        if (locationOnScreen == null)
            Location = UIEnum.topLeft;
        else
            Location = locationOnScreen;
        Position.AddVector(UIElementPosition());
    }

    public void ChangeSize(Scale newSize){
        System.out.println(newSize.GetWidth() + "" + newSize.GetHeight());
        Size.SetScale(newSize);
        System.out.println(Size.GetWidth() + "" + Size.GetHeight());

    }

    public void setWidth(int width){
        Size.SetWidth(width);
    }
    public void setHeight(int height){
        Size.SetHeight(height);
    }

    public void addWidth(int width){
        Size.addWidth(width);
    }
    public void addHeight(int height){
        Size.addHeight(height);
    }

    public void addX(int x) { Position.addX(x);}
    public void addY(int y) { Position.addX(y);}


    public void MinX(int x) { Position.minY(x);}
    public void MinY(int y) { Position.minX(y);}

    public void setPosition(Vector2 pos) { Position = pos;}


    @Override
    public void RenderUIElement(Graphics graphics) {
        graphics.drawImage(Image ,(int)Position.GetX(), (int)Position.GetY(), Size.GetWidth(), Size.GetHeight(), null);
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
