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
        gameTitle.components.sprite = new Sprite(new Vector2(), new Vector2(800, 100), "title.png");
        gameTitle.position = new Vector2(400, 50);

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
        fourth.components.sprite = new Sprite(new Vector2(),new Vector2(580,130), "start.png");
        fourth.position = new Vector2(530, 690);
        fourth.components.script = new MenuButtonsScript();
        fourth.components.click = true;

        GameObject controlsTitle = new GameObject("controlsTitle",mapSelection);
        controlsTitle.components.sprite = new Sprite(new Vector2(), new Vector2(800, 100), "controls.png");
        controlsTitle.position = new Vector2(450, 50);

        GameObject placingBombs = new GameObject("PlacingBombs",mapSelection);
        placingBombs.components.sprite = new Sprite(new Vector2(), new Vector2(600, 40), "placingBombs.png");
        placingBombs.position = new Vector2(550, 200);

        GameObject movement = new GameObject("Movement",mapSelection);
        movement.components.sprite = new Sprite(new Vector2(), new Vector2(350, 40), "movement.png");
        movement.position = new Vector2(650, 390);

        addControlsImg("enter", "enter.png", 1300, 270, mapSelection);
        addControlsImg("u", "u.png", 800, 270, mapSelection);
        addControlsImg("q", "q.png", 300, 270, mapSelection);

        addControlsImg("w", "w.png", 300, 450, mapSelection);
        addControlsImg("s", "s.png", 300, 560, mapSelection);
        addControlsImg("a", "a.png", 190, 500, mapSelection);
        addControlsImg("d", "d.png", 410, 500, mapSelection);

        addControlsImg("i", "i.png", 800, 450, mapSelection);
        addControlsImg("k", "k.png", 800, 560, mapSelection);
        addControlsImg("j", "j.png", 690, 500, mapSelection);
        addControlsImg("l", "l.png", 910, 500, mapSelection);

        addControlsImg("up", "up.png", 1300, 450, mapSelection);
        addControlsImg("down", "down.png", 1300, 560, mapSelection);
        addControlsImg("left", "left.png", 1190, 500, mapSelection);
        addControlsImg("right", "right.png", 1410, 500, mapSelection);


    }

    private void addControlsImg(String objectName, String spriteName, int width, int height, GameScene gameScene){
        GameObject title = new GameObject(objectName,gameScene);
        title.components.sprite = new Sprite(new Vector2(), new Vector2(100, 100), spriteName);
        title.position = new Vector2(width, height);
    }

}
