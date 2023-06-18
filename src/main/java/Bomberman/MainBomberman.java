package Bomberman;

import AllirEngine.*;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1280, 720,1600,900);
        GameMenu menu = new GameMenu();
        GameLoader gameLoader= new GameLoader();
        menu.loadMenu();
        menu.loadMapSelection();
        menu.loadControls();
        menu.loadAbout();

        //gameLoader.LoadRandomMap();
        gameLoader.LoadMap(1,"map1.txt");
        gameLoader.LoadMap(2,"map2.txt");
        gameLoader.LoadMap(3,"map3.txt");
        gameLoader.LoadMap(4,"map4.txt");
        gameLoader.LoadMap(5,"map5.txt");
        gameLoader.LoadMap(6,"map6.txt");
        //gameLoader.LoadFPSDisplay();

        GameManager.LaunchGame();

    }
}
