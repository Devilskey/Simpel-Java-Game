package engine.abstractions;

import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;

import java.awt.*;

public abstract class UserInterface {
    public String Name;
    public Vector2 Position = new Vector2(0,0);
    public Scale Size = new Scale(0,0);
    public boolean IsButton = false;


    public abstract void RenderUIElement(Graphics graphics);

    public void Update(){

    }
}
