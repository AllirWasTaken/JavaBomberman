package AllirEngine.Components;

import AllirEngine.GameObject;
import AllirEngine.Vector2;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import java.util.Scanner;


public class Sprite {
    public Vector2 relativePosition;
    public SpriteType type;
    public Vector2 size;
    //Simple
    public Color color;
    //Image
    public Image image;
    public ImageView imageView;

    public boolean loaded;

    public Sprite(Vector2 relativePosition, Vector2 spriteSize,String spriteName){
        this.relativePosition=relativePosition;
        this.type=SpriteType.IMAGE;
        LoadSprite(spriteName,spriteSize);
        loaded=false;
    }
    public Sprite(Vector2 relativePosition,float circleRadius,Color color ){
        this.relativePosition=relativePosition;
        this.type=SpriteType.SIMPLE_CIRCLE;
        this.size=new Vector2(circleRadius);
        this.color=color;
        loaded=false;
    }

    public Sprite(Vector2 relativePosition,Vector2 rectangleSize,Color color ){
        this.relativePosition=relativePosition;
        this.type=SpriteType.SIMPLE_RECTANGLE;
        this.size=rectangleSize;
        this.color=color;
        loaded=false;
    }

    private void LoadSprite(String spriteName,Vector2 size){
        this.size=size;

        this.image = new Image(getClass().getResourceAsStream("/img/"+spriteName));
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(this.size.x);
        this.imageView.setFitHeight(this.size.y);
    }




}
