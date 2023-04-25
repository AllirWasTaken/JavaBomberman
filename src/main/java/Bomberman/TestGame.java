package Bomberman;

import AllirEngine.*;

public class TestGame {
    public static void main(String[] args) {
        GameManager.Initialize(args);
        new Scene("TestScene",800,600);





        GameManager.LaunchGame();
    }
}
