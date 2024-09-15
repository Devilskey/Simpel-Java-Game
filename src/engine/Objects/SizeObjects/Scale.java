package engine.Objects.SizeObjects;

public class Scale {
    private int Width;
    private int Height;
    public Scale(int Width, int Height){
        this.Width = Width;
        this.Height = Height;
    }

    public String print(){
        return "\n    Width = " + Width + "\n    Height = " + Height;
    }

    public int GetWidth (){
        return Width;
    }

    public int GetHeight(){
        return Height;
    }
    public void SetWidth(int Width){
        this.Width = Width;
    }

    public void SetHeight(int Height){
        this.Height = Height;
    }

    public void addHeight(int add){
        this.Height += add;
    }
    public void addWidth(int add){
        this.Width += add;
    }

    public void MinWidth(int min) { this.Width -= min;}
    public void MinHeight(int min) { this.Height -= min; }

    public void SetScale(Scale NewScale){
        this.Width = NewScale.GetWidth();
        this.Height = NewScale.GetHeight();

    }

    public void SetScale(int Width, int Height){
        this.Width = Width;
        this.Height = Height;
    }

}
