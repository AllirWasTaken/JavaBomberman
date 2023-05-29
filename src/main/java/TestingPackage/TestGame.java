package TestingPackage;

import AllirEngine.Components.Sprite;
import AllirEngine.Components.TextSprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.GameScene;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;


public class TestGame {
    public static void main(String[] args){
        GameManager.Initialize(args, 1200,600,1600,900);
        GameScene scene=new GameScene("TestScene");
        GameObject allir=new GameObject("Allir");

        allir.components.script=new TestScript();
        allir.components.sprite=new Sprite(new Vector2(),new Vector2(300,300),"postać.png");
        allir.components.click=true;
        allir.components.hover=true;
        allir.components.textSprite=new TextSprite(new Vector2(),"Akira");

        GameObject wall = new GameObject("wall1");
        wall.components.sprite=new Sprite(new Vector2(),new Vector2(300,300),"wallIn.png");

        ((TestScript) allir.components.script).player=1;






        scene.backgroundColor=Color.GRAY;

        GameManager.LaunchGame();
    }
}
