package Bomberman;

import AllirEngine.*;

public class MainBomberman {
    public static void main(String[] args) {
        GameManager.Initialize(args, 1400, 760);
        GameMenu menu = new GameMenu();
        menu.loadMenu();
        GameManager.LaunchGame();

    }
}
