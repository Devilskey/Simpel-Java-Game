package objects.SizeObjects;

public class Scale {
    private float Width;
    private float Height;
    public Scale(float Width, float Height){
        this.Width = Width;
        this.Height = Height;
    }

    public float GetWidth (){
        return Width;
    }

    public float GetHeight(){
        return Height;
    }
    public void SetWidth(float Width){
        this.Width = Width;
    }

    public void SetHeight(float Height){
        this.Height = Height;
    }

    public void addHeight(float add){
        this.Height += add;
    }
    public void addWidth(float add){
        this.Width += add;
    }
}
