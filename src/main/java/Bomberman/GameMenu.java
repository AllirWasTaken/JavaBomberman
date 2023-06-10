package Bomberman;

import AllirEngine.Components.Sprite;
import AllirEngine.GameObject;
import AllirEngine.GameScene;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;

public class GameMenu {

    public void loadMenu(){
        GameScene menuScene = new GameScene("Menu");
        menuScene.backgroundColor = Color.CORAL;

        GameObject gameTitle = new GameObject("gameTitle",menuScene);
        gameTitle.components.sprite = new Sprite(new Vector2(),new Vector2(570,100), "title.png");
        gameTitle.position =  new Vector2(500,50);

        GameObject startButton = new GameObject("startButton",menuScene);
        startButton.components.sprite = new Sprite(new Vector2(),new Vector2(250,60), "start.png");
        startButton.position = new Vector2(660, 280);
        startButton.components.script = new MenuButtonsScript();
        startButton.components.click = true;

        GameObject aboutButton = new GameObject("aboutButton",menuScene);
        aboutButton.components.sprite = new Sprite(new Vector2(),new Vector2(250,60), "about.png");
        aboutButton.position = new Vector2(660, 380);
        aboutButton.components.script = new MenuButtonsScript();
        aboutButton.components.click = true;

        GameObject exitButton = new GameObject("exitButton",menuScene);
        exitButton.components.sprite = new Sprite(new Vector2(),new Vector2(190,60), "exit.png");
        exitButton.position = new Vector2(690, 480);
        exitButton.components.click = true;
        exitButton.components.script = new MenuButtonsScript();
    }

    public void loadGameTypeSelection(){
        GameScene selectionScene = new GameScene("GameTypeSelection");
        selectionScene.backgroundColor = Color.CORAL;

        GameObject oneScreen = new GameObject("oneScreen",selectionScene);
        oneScreen.components.sprite = new Sprite(new Vector2(),new Vector2(600,150), "exit.png");
        oneScreen.position = new Vector2(500, 400);
        oneScreen.components.script = new MenuButtonsScript();
        oneScreen.components.click = true;

        GameObject multiplayer = new GameObject("Multiplayer",selectionScene);
        multiplayer.components.sprite = new Sprite(new Vector2(),new Vector2(600,150), "about.png");
        multiplayer.position = new Vector2(500, 200);
        multiplayer.components.script = new MenuButtonsScript();
        multiplayer.components.click = true;
    }

    public void loadMapSelection(){
        GameScene mapSelection = new GameScene("mapSelection");
        mapSelection.backgroundColor = Color.CORAL;

        GameObject first = new GameObject("firstMap",mapSelection);
        first.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "RandomMap.png");
        first.position = new Vector2(350, 100);
        first.components.script = new MenuButtonsScript();
        first.components.click = true;

        GameObject second = new GameObject("secondMap",mapSelection);
        second.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "NotDoneMap.png");
        second.position = new Vector2(850, 100);
        second.components.script = new MenuButtonsScript();
        second.components.click = true;

        GameObject third = new GameObject("thirdMap",mapSelection);
        third.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "NotDoneMap.png");
        third.position = new Vector2(350, 500);
        third.components.script = new MenuButtonsScript();
        third.components.click = true;

        GameObject fourth = new GameObject("fourthMap",mapSelection);
        fourth.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "NotDoneMap.png");
        fourth.position = new Vector2(850, 500);
        fourth.components.script = new MenuButtonsScript();
        fourth.components.click = true;
    }

    public void loadAbout(){

    }

    public void loadControls(){
        GameScene mapSelection = new GameScene("controls");
        mapSelection.backgroundColor = Color.CORAL;

        GameObject fourth = new GameObject("StartGame",mapSelection);
        fourth.components.sprite = new Sprite(new Vector2(),new Vector2(600,200), "NotDoneMap.png");
        fourth.position = new Vector2(500, 600);
        fourth.components.script = new MenuButtonsScript();
        fourth.components.click = true;

    }

}
