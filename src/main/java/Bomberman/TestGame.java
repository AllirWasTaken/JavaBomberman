package Bomberman;

import AllirEngine.*;
import AllirEngine.Components.Sprite;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;


public class TestGame {
    public static void main(String[] args) throws FileNotFoundException {
        GameManager.Initialize(args, 1600,900);
        GameScene scene=new GameScene("TestScene");
        GameObject allir=new GameObject("Allir");
        GameObject madzia = new GameObject("madzia");
        madzia.components.script=new TestScript();
        madzia.components.sprite = new Sprite(new Vector2(0,0),new Vector2(100,100),Color.PINK);
        madzia.position=new Vector2(300,300);
        allir.components.script=new TestScript();
        allir.components.sprite=new Sprite(new Vector2(0,0),new Vector2(100,100),Color.WHITE);

        ((TestScript) allir.components.script).player=1;
        ((TestScript) madzia.components.script).player=2;

        allir.components.physicalBody=new TestColider(new Vector2(0,0),new Vector2(100,100));
        madzia.components.physicalBody=new TestColider(new Vector2(0,0),new Vector2(100,100));



        scene.backgroundColor=Color.GRAY;

        GameManager.LaunchGame();
    }
}
