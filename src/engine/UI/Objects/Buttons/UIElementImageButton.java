package engine.UI.Objects.Buttons;
import Game.Statics.Input;
import engine.Handlers.Peripherals.MouseMotionHandler;
import engine.Interfaces.Action;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.Objects.UIElementImage;
import engine.UI.enums.UIEnum;
import engine.abstractions.UserInterface;
import java.awt.*;

public class UIElementImageButton extends UserInterface {
    private Action Function;
    private Scale TotalSize;
    private boolean ActivateOncePerPress;
    private boolean AlreadyPressed = false;
    private UIElementImage Image;
    private boolean IsImageCentered = false;

    public void SetIsImageCentered(boolean isImageCentered){
        this.IsImageCentered = isImageCentered;
    }

    public UIElementImageButton (String ImagePath, String ButtonName, Vector2 ButtonPosition,  Scale Size, UIEnum LocationOnScreen){
        Name = ButtonName;
        Position = ButtonPosition;
        TotalSize = Size;

        Image = new UIElementImage(ButtonPosition, Size, ImagePath, ButtonName+"-Image");
    }

    public UIElementImageButton (String ImagePath, String content, String ButtonName, Vector2 ButtonPosition, UIEnum LocationOnScreen){
        Name = ButtonName;
        Position = ButtonPosition;

    }

    public void SetActivateOncePerPress (boolean activateOncePerPress) {
        ActivateOncePerPress = activateOncePerPress;
    }

    public void SetFunction (Action newFunction){
        Function = newFunction;
    }

    @Override
    public void RenderUIElement(Graphics graphics) {
        Image.RenderUIElement(graphics);
    }

    @Override
    public void Update() {
        super.Update();
        boolean HoversOverButton = HoverCheck();

        if(HoversOverButton) {
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
        }
    }

    public void ChangeSize(Scale newSize){
        Image.ChangeSize(newSize);

    }

    public void ChangePosition(Vector2 newPosition){
        Image.Position = newPosition;

    }

    public void setWidth(int width){
        if(IsImageCentered){
            Image.setWidth(width / 2);
            Image.addX(-(width / 2));
            return;
        }
            Image.setWidth(width);
    }
    public void setHeight(int height){
        if(IsImageCentered){
            Image.setHeight(height / 2);
            Image.addY( -(height / 2));
            return;
        }
    }


    public void addWidth(int width){
        if(IsImageCentered){
            int AddWidth = width / 2;
            Image.addWidth(width);
            Image.MinX(AddWidth);
            return;
        }
        Image.setWidth(width);
    }
    public void addHeight(int height){
        if(IsImageCentered){
            int Addheight = height / 2;
            Image.addHeight(height);
            Image.MinY(Addheight);
            System.out.println(IsImageCentered);
            return;
        }
        Image.addHeight(height);
        System.out.println(IsImageCentered + " After");

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
