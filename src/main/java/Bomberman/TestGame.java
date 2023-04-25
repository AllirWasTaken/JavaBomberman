package Bomberman;

import AllirEngine.*;

public class TestGame {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1600,900);
        new GameScene("TestScene");

        GameObject allir=new GameObject("Allir");
        allir.components.script=new TestScript();
        ((TestScript) allir.components.script).i=5;


        GameManager.LaunchGame();
    }
}
