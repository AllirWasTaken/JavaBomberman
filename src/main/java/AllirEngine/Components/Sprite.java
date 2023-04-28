package AllirEngine.Components;

import AllirEngine.GameObject;
import AllirEngine.Vector2;
import javafx.scene.image.Image;

import javafx.scene.paint.Color;


import javax.imageio.ImageIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.net.URL;


public class Sprite {
    public Vector2 relativePosition;
    public SpriteType type;
    public Vector2 size;
    //Simple
    public Color color;
    //Image
    public Image image;

    public Sprite(Vector2 relativePosition){
        this.relativePosition=relativePosition;
        this.type=SpriteType.IMAGE;
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

    public void LoadSprite(String spriteName,Vector2 size) throws FileNotFoundException {
        this.size=size;
        String path = getClass().getResource("/img/"+spriteName).toString();
        FileInputStream fs=new FileInputStream(path);
        this.image = new Image(fs);
    }


}
