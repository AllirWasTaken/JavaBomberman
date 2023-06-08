package PingPong;

import AllirEngine.*;
import AllirEngine.Components.Sprite;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class MainPong {
    public static void main(String[] args) throws FileNotFoundException {
        GameManager.Initialize(args,1600,900,1600,900);
        GameScene scene =new GameScene("MainPong");
        GameObject player1=new GameObject("player1");
        GameObject player2=new GameObject("player2");
        GameObject ball = new GameObject("ball");

        GameObject wall1 = new GameObject("wall1");
        GameObject wall2 = new GameObject("wall2");


        scene.backgroundColor= Color.BLACK;

        player1.components.sprite=new Sprite(new Vector2(),new Vector2(200,200),Color.WHITE);
        player1.position=new Vector2(-180,350);
        player1.components.script=new PlayerScript(1);
        player1.components.physicalBody=new BallColision(new Vector2(),new Vector2(200,200));


        player2.components.sprite=new Sprite(new Vector2(),new Vector2(200,200),Color.WHITE);
        player2.position=new Vector2(1580,350);
        player2.components.script=new PlayerScript(2);
        player2.components.physicalBody=new BallColision(new Vector2(),new Vector2(200,200));


        ball.components.sprite=new Sprite(new Vector2(0,0),20,Color.WHITE);
        ball.components.physicalBody=new BallColision(new Vector2(),new Vector2(20,20));
        ball.components.script=new BallScript();
        ((BallScript) ball.components.script).speed=new Vector2();
        ball.components.physicalBody.DetectColisions=true;

        wall1.components.sprite=new Sprite(new Vector2(),new Vector2(2000,20),Color.GRAY);
        wall1.position=new Vector2(-100,-20);
        wall1.components.physicalBody=new BallColision(new Vector2(),new Vector2(2000,20));

        wall2.components.sprite=new Sprite(new Vector2(),new Vector2(2000,20),Color.GRAY);
        wall2.position=new Vector2(-100,900);
        wall2.components.physicalBody=new BallColision(new Vector2(),new Vector2(2000,20));





    GameManager.LaunchGame();

    }
}
