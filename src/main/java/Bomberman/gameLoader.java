package Bomberman;

import AllirEngine.*;
import AllirEngine.Components.*;
import javafx.scene.paint.Color;

import java.util.Random;

public class gameLoader {
    public void LoadMap1(){
        GameScene gameScene=new GameScene("Map1");

        for(int y=1;y<15;y++){
            for(int x=1;x<31;x++){
                GameObject object= new GameObject("GridTile",gameScene);
                object.position=new Vector2(x*50,y*50+100);
                object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"podłoga.png");
            }
        }
        for(int y=0;y<16;y++){
            for(int x=0;x<32;x++){
                if((y==0||y==15)||(x==0||x==31)) {
                    GameObject object = new GameObject("GridTile",gameScene);
                    object.position = new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "wallIn.png");
                }
            }
        }
        Random r=new Random();
        for(int y=1;y<15;y++){
            for(int x=1;x<31;x++) {
                if (r.nextInt(0, 4) == 0) {
                    GameObject object = new GameObject("Wall",gameScene);
                    object.position = new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "wallDe.png");
                }
            }
        }

        GameObject panel = new GameObject("UIPanel",gameScene);
        panel.components.sprite=new Sprite(new Vector2(),new Vector2(1600,100),Color.GRAY);
        GameObject object = new GameObject("Character",gameScene);
        object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"postać.png");
        object.position=new Vector2(500,500);
        object.components.script=new PlayerControl();
        ((PlayerControl) object.components.script).player=2;

    }
}
