package AllirEngine;

public class Vector2 {
    public float x,y;

    public Vector2(float... a){
        if(a.length>0) this.x=a[0];
        else this.x=0;
        if(a.length>1) this.y=a[0];
        else this.y=0;
    }
}
