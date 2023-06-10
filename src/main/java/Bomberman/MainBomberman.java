package Bomberman;

import AllirEngine.*;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1600, 900,1600,900);
        GameMenu menu = new GameMenu();
        GameLoader gameLoader= new GameLoader();
        menu.loadMenu();
        menu.loadMapSelection();
        menu.loadControls();

        //gameLoader.LoadRandomMap();
        gameLoader.LoadMap(1,"map1.txt");
        gameLoader.LoadMap(2,"map2.txt");
        gameLoader.LoadMap(3,"map3.txt");
        gameLoader.LoadMap(4,"map4.txt");
        gameLoader.LoadUI();
        gameLoader.LoadCharacters();
        //gameLoader.LoadFPSDisplay();


        GameManager.LaunchGame();

    }
}
