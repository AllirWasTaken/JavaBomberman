package Bomberman;

import AllirEngine.*;
import AllirEngine.Components.Sprite;
import javafx.scene.paint.Color;



public class TestGame {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1600,900);
        GameScene scene=new GameScene("TestScene");
        GameObject allir=new GameObject("Allir");
        allir.components.script=new TestScript();
        allir.components.sprite=new Sprite(new Vector2(0,0),new Vector2(10,10), Color.AQUA);
        ((TestScript) allir.components.script).i=5;


        GameManager.LaunchGame();
    }
}
