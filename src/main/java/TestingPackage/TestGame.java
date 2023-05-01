package TestingPackage;

import AllirEngine.*;
import AllirEngine.Components.Sprite;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;


public class TestGame {
    public static void main(String[] args){
        GameManager.Initialize(args, 1600,900);
        GameScene scene=new GameScene("TestScene");
        GameObject allir=new GameObject("Allir");

        allir.components.script=new TestScript();
        allir.components.sprite=new Sprite(new Vector2(),new Vector2(300,300),"Akira.png");
        allir.components.click=true;
        allir.components.hover=true;

        ((TestScript) allir.components.script).player=1;






        scene.backgroundColor=Color.GRAY;

        GameManager.LaunchGame();
    }
}
