package Bomberman;

import AllirEngine.Components.Sprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.GameScene;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;

public class GameMenu {

    public void loadMenu(){
        GameScene menuScene = new GameScene("Menu");
        GameManager.SwitchScene("Menu");
        menuScene.backgroundColor = Color.CORAL;

        GameObject gameTitle = new GameObject("gameTitle");
        gameTitle.components.sprite = new Sprite(new Vector2(),new Vector2(570,100), "title.png");
        gameTitle.position =  new Vector2(500,50);

        GameObject startButton = new GameObject("startButton");
        startButton.components.sprite = new Sprite(new Vector2(),new Vector2(250,60), "start.png");
        startButton.position = new Vector2(660, 280);
        startButton.components.script = new MenuButtonsScript();
        startButton.components.click = true;

        GameObject aboutButton = new GameObject("aboutButton");
        aboutButton.components.sprite = new Sprite(new Vector2(),new Vector2(250,60), "about.png");
        aboutButton.position = new Vector2(660, 380);
        aboutButton.components.script = new MenuButtonsScript();
        aboutButton.components.click = true;

        GameObject exitButton = new GameObject("exitButton");
        exitButton.components.sprite = new Sprite(new Vector2(),new Vector2(190,60), "exit.png");
        exitButton.position = new Vector2(690, 480);
        exitButton.components.click = true;
        exitButton.components.script = new MenuButtonsScript();
    }
}
