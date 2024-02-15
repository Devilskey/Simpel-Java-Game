package objects;

public class Vector2 {
    private float x;
    private float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void SetVector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float GetX (){
        return x;
    }

    public float GetY(){
        return y;
    }
    public void SetX(float x){
        this.x =x;
    }

    public void SetY(float y){
        this.y = y;
    }

    public void addY(float add){
        this.y += add;
    }
    public void addX(float add){
        this.x += add;
    }
}