package objects.UserInterfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class UserInterfaceObjects {
    private String name;
    private int width, height;
    private int positionX, positionY, positionZ;
    private String content;
    private Color backgroundColor;
    private String borderStyle;
    private Color borderColor;
    private int borderThickness;
    private Color fontColor;
    private int fontSize;
    private String fontType;
    private boolean textWrap;
    private boolean isButton;

    public UserInterfaceObjects(String name, int width, int height, int positionX, int positionY, int positionZ,
                                String content, String backgroundColor, String borderStyle, String borderColor, int borderThickness,
                                String fontColor, int fontSize, String fontType, boolean textWrap, boolean isButton) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.content = content;
        this.backgroundColor = "none".equals(backgroundColor) ? null : Color.decode(backgroundColor);
        this.borderStyle = borderStyle;
        this.borderColor = "none".equals(borderColor) ? null : Color.decode(borderColor);
        this.borderThickness = borderThickness;
        this.fontColor = "none".equals(fontColor) ? Color.BLACK : Color.decode(fontColor);
        this.fontSize = fontSize;
        this.fontType = fontType;
        this.textWrap = textWrap;
        this.isButton = isButton;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getPositionX() { return positionX; }
    public void setPositionX(int positionX) { this.positionX = positionX; }

    public int getPositionY() { return positionY; }
    public void setPositionY(int positionY) { this.positionY = positionY; }

    public int getPositionZ() { return positionZ; }
    public void setPositionZ(int positionZ) { this.positionZ = positionZ; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Color getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = "none".equals(backgroundColor) ? null : Color.decode(backgroundColor);
    }

    public String getBorderStyle() { return borderStyle; }
    public void setBorderStyle(String borderStyle) { this.borderStyle = borderStyle; }

    public Color getBorderColor() { return borderColor; }
    public void setBorderColor(String borderColor) {
        this.borderColor = "none".equals(borderColor) ? null : Color.decode(borderColor);
    }

    public int getBorderThickness() { return borderThickness; }
    public void setBorderThickness(int borderThickness) { this.borderThickness = borderThickness; }

    public Color getFontColor() { return fontColor; }
    public void setFontColor(String fontColor) {
        this.fontColor = "none".equals(fontColor) ? Color.BLACK : Color.decode(fontColor);
    }

    public int getFontSize() { return fontSize; }
    public void setFontSize(int fontSize) { this.fontSize = fontSize; }

    public String getFontType() { return fontType; }
    public void setFontType(String fontType) { this.fontType = fontType; }

    public boolean isTextWrap() { return textWrap; }
    public void setTextWrap(boolean textWrap) { this.textWrap = textWrap; }

    public boolean isButton() { return isButton; }
    public void setButton(boolean isButton) { this.isButton = isButton; }

    public void render(Graphics graphics) {
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
            graphics.fillRect(positionX, positionY, width, height);
        }

        if (borderThickness > 0 && borderColor != null) {
            graphics.setColor(borderColor);
            graphics.drawRect(positionX, positionY, width, height);
        }

        graphics.setFont(new Font(fontType, Font.PLAIN, fontSize));
        graphics.setColor(fontColor);

        if (textWrap) {
            drawWrappedText(graphics, content, positionX, positionY, width, height);
        } else {
            graphics.drawString(content, positionX, positionY + graphics.getFontMetrics().getAscent());
        }
    }

    private void drawWrappedText(Graphics g, String text, int x, int y, int maxWidth, int maxHeight) {
        FontMetrics fm = g.getFontMetrics();
        int lineHeight = fm.getHeight();
        int curX = x;
        int curY = y + fm.getAscent();

        for (String word : text.split(" ")) {
            int wordWidth = fm.stringWidth(word + " ");
            if (curX + wordWidth > x + maxWidth) {
                curX = x;
                curY += lineHeight;
                if (curY + lineHeight > y + maxHeight) {
                    break;
                }
            }
            g.drawString(word, curX, curY);
            curX += wordWidth;
        }
    }
}
