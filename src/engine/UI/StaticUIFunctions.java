package engine.UI;

import Game.Statics.GameData;
import engine.Objects.SizeObjects.Scale;
import engine.Objects.SizeObjects.Vector2;
import engine.UI.enums.UIEnum;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class StaticUIFunctions {

    public static Scale GetTextSize(String Content, int FontSize){
        Font font = new Font(GameData.FontName, Font.PLAIN, FontSize);

        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);

        // Measure the text using TextLayout
        TextLayout layout = new TextLayout(Content, font, frc);
        float textWidth = layout.getAdvance();
        float textHeight = layout.getAscent() + layout.getDescent();

        return new Scale((int) textWidth, (int)textHeight);
    }

    public static Vector2 UIElementTextPosition(UIEnum Location, String Content, int FontSize, int FontType) {
        Vector2 UIposition = new Vector2(0,0);

        Scale SizeText = GetTextSize(Content, FontSize);

        switch (Location){
            case midCenter, topCenter, bottomCenter:
                    return new Vector2(-((float) SizeText.GetWidth() / 2), 0);
            case midRight, topRight, bottomRight:
                return new Vector2(-SizeText.GetWidth() ,-SizeText.GetHeight());
        }
        return UIposition;
    }

    public static Vector2 UIElementPosition(UIEnum Location) {
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
