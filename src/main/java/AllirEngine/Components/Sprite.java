package AllirEngine.Components;

import AllirEngine.GameObject;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;


public class Sprite {
    public Vector2 relativePosition;
    public SpriteType type;
    public Vector2 size;
    //Simple
    public Color color;
    //Image
    public String imageName;

    public Sprite(Vector2 relativePosition,Vector2 size,String ImageName){
        this.relativePosition=relativePosition;
        this.type=SpriteType.IMAGE;
        this.size=size;
        this.imageName=ImageName;
    }
    public Sprite(Vector2 relativePosition,float circleRadius,Color color ){
        this.relativePosition=relativePosition;
        this.type=SpriteType.SIMPLE_CIRCLE;
        this.size=new Vector2(circleRadius);
        this.color=color;
    }

    public Sprite(Vector2 relativePosition,Vector2 rectangleSize,Color color ){
        this.relativePosition=relativePosition;
        this.type=SpriteType.SIMPLE_RECTANGLE;
        this.size=rectangleSize;
        this.color=color;
    }


}
