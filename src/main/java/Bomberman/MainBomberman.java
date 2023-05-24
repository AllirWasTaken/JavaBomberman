package Bomberman;

import AllirEngine.*;
import AllirEngine.Components.Sprite;
import AllirEngine.Components.TextSprite;
import javafx.scene.paint.Color;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 900, 600);
        GameScene scene = new GameScene("menu");
        scene.backgroundColor = Color.WHITE;
        GameObject object = new GameObject("box");
        object.components.sprite = new Sprite(new Vector2(),new Vector2(100,100), "Akira.png");
        object.position =  new Vector2(50,50);
        object.components.script = new BoxScript();
        object.components.hover = true;
        object.components.click = true;
        object.components.textSprite = new TextSprite(new Vector2(20,20), "halo", 12);
        GameScene nextscene = new GameScene("pusto");
        GameObject object1 = new GameObject("box1");
        object1.components.sprite = new Sprite(new Vector2(),new Vector2(100,100), "Akira.png");
        object1.position = new Vector2(250, 50);
        object.components.physicalBody = new Collide();
        object1.components.physicalBody = new Collide();
        GameManager.LaunchGame();
    }
}
