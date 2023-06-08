package Bomberman;

import AllirEngine.*;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1600, 900,1600,900);
        GameMenu menu = new GameMenu();
        GameLoader gameLoader= new GameLoader();
        menu.loadMenu();
        menu.loadGameTypeSelection();
        menu.loadMapSelection();

        gameLoader.LoadMap1();
        gameLoader.LoadFPSDisplay();


        GameManager.LaunchGame();

    }
}
