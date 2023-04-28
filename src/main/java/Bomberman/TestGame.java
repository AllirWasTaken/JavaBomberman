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

        scene.backgroundColor=Color.GRAY;

        GameManager.LaunchGame();
    }
}
