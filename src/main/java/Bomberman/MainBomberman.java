package Bomberman;

import AllirEngine.*;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1600, 900,1600,900);
        GameMenu menu = new GameMenu();
        gameLoader gameLoader= new gameLoader();
        menu.loadMenu();
        menu.loadGameTypeSelection();
        menu.loadMapSelection();

        gameLoader.LoadMap1();


        GameManager.LaunchGame();

    }
}
