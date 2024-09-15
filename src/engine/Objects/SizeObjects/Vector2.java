package engine.Objects.SizeObjects;

public class Vector2 {
    private float  x;
    private float y;
    public Vector2(float x, float y){
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
        this.x = x;
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


    public void minY(float add){
        this.y -= add;
    }
    public void minX(float add){
        this.x -= add;
    }

    public void AddVector(Vector2 add){
        this.x += add.GetX();
        this.y += add.GetY();

    }
}