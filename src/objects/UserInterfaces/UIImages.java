package objects.UserInterfaces;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UIImages {
  private String name;
  private int width, height;
  private int positionX, positionY, positionZ;
  private String contentPath;
  private String borderStyle;
  private Color borderColor;
  private int borderThickness;
  private boolean isButton;
  private Image image;

  public UIImages(String name, int width, int height, int positionX, int positionY, int positionZ, String contentPath,
      String borderStyle, String borderColor, int borderThickness, boolean isButton) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.positionX = positionX;
    this.positionY = positionY;
    this.positionZ = positionZ;
    this.contentPath = contentPath;
    this.borderStyle = borderStyle;
    this.borderColor = "none".equals(borderColor) ? null : Color.decode(borderColor);
    this.borderThickness = borderThickness;
    this.isButton = isButton;
    loadImage();
  }

  private void loadImage() {
    try {
      image = ImageIO.read(new File(contentPath));
    } catch (IOException e) {
      e.printStackTrace();
      image = null;
    }
  }

  public void render(Graphics graphics) {
    Graphics2D graphics2d = (Graphics2D) graphics.create();

    if (image != null) {
      graphics2d.drawImage(image, positionX, positionY, width, height, null);
    }

    if (borderThickness > 0 && borderColor != null) {
      graphics2d.setColor(borderColor);
      graphics2d.setStroke(new BasicStroke(borderThickness));
      graphics2d.drawRect(positionX, positionY, width, height);
    }

    graphics2d.dispose();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getPositionX() {
    return positionX;
  }

  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  public int getPositionY() {
    return positionY;
  }

  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }

  public int getPositionZ() {
    return positionZ;
  }

  public void setPositionZ(int positionZ) {
    this.positionZ = positionZ;
  }

  public String getContentPath() {
    return contentPath;
  }

  public void setContentPath(String contentPath) {
    this.contentPath = contentPath;
    loadImage();
  }

  public String getBorderStyle() {
    return borderStyle;
  }

  public void setBorderStyle(String borderStyle) {
    this.borderStyle = borderStyle;
  }

  public Color getBorderColor() {
    return borderColor;
  }

  public void setBorderColor(String borderColor) {
    this.borderColor = "none".equals(borderColor) ? null : Color.decode(borderColor);
  }

  public int getBorderThickness() {
    return borderThickness;
  }

  public void setBorderThickness(int borderThickness) {
    this.borderThickness = borderThickness;
  }

  public boolean isButton() {
    return isButton;
  }

  public void setButton(boolean isButton) {
    this.isButton = isButton;
  }
}
