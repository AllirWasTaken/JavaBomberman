package SampleScene;

import AllirEngine.Components.Sprite;
import AllirEngine.Components.TextSprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.GameScene;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;

public class SceneManagerScript {

    GameScene gameScene;

    void CreateGrid(){
        for(int y=1;y<15;y++){
            for(int x=1;x<31;x++){
                GameObject object= new GameObject("GridTile");
                object.position=new Vector2(x*50,y*50+100);
                object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"podłoga.png");
            }
        }
        for(int y=0;y<16;y++){
            for(int x=0;x<32;x++){
                if((y==0||y==15)||(x==0||x==31)) {
                    GameObject object = new GameObject("GridTile");
                    object.position = new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "wallIn.png");
                }
            }
        }
    }

    void CreateUI(){
        GameObject object = new GameObject("UIPanel");
        object.components.sprite=new Sprite(new Vector2(),new Vector2(1600,100),Color.GRAY);

    }

    public void start(){
        gameScene=new GameScene("MainScene");
        CreateGrid();
        CreateUI();

        GameObject object = new GameObject("Character");
        object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"postać.png");
        object.position=new Vector2(500,500);

    }
}
