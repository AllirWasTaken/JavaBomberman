package Bomberman;

import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Scene;

public class TestGame {
    public static void main(String[] args) {
        new GameManager();
        new Scene();
        GameObject Allir=new GameObject();
        Allir.components.script=new TestScript();
        GameManager.LaunchGame();

    }
}
