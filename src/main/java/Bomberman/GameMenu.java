package Bomberman;

import AllirEngine.Components.Sprite;
import AllirEngine.Components.TextSprite;
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
        first.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "map1.png");
        first.position = new Vector2(350, 100);
        first.components.script = new MenuButtonsScript();
        first.components.click = true;

        GameObject second = new GameObject("secondMap",mapSelection);
        second.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "map2.png");
        second.position = new Vector2(850, 100);
        second.components.script = new MenuButtonsScript();
        second.components.click = true;

        GameObject third = new GameObject("thirdMap",mapSelection);
        third.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "map3.png");
        third.position = new Vector2(350, 500);
        third.components.script = new MenuButtonsScript();
        third.components.click = true;

        GameObject fourth = new GameObject("fourthMap",mapSelection);
        fourth.components.sprite = new Sprite(new Vector2(),new Vector2(400,300), "map4.png");
        fourth.position = new Vector2(850, 500);
        fourth.components.script = new MenuButtonsScript();
        fourth.components.click = true;

        GameObject text = new GameObject("text",mapSelection);
        text.position=new Vector2(450,20);
        text.components.textSprite=new TextSprite(new Vector2(0,50),"CHOOSE YOUR MAP!",50);
    }

    public void loadAbout(){
        GameScene scene=new GameScene("About");
        scene.backgroundColor=Color.CORAL;

        GameObject backToMenu=new GameObject("BackToMenuLite",scene);
        backToMenu.position=new Vector2(1500,0);
        backToMenu.components.sprite=new Sprite(new Vector2(5,5),new Vector2(90,90),"ExitToMenu.png");
        backToMenu.components.script=new UIButtonsScript();
        backToMenu.components.click=true;

        GameObject text = new GameObject("text",scene);
        text.position=new Vector2(30,30);
        text.components.textSprite=new TextSprite(new Vector2(0,16),
                "Java Bomberman to gra w której celem jest pozostanie ostatnim graczem na planszy by osiągność zwycięstwo\n" +
                        "W przypadku gdy żaden gracz nie przeżyje, nikt nie wygrywa\n" +
                        "Gracze są rozmieszczeni w rogach planszy o wymiarach 32x16\n" +
                        "Elemenety mapy to niezniszcalna ściana, zniszczalna ściana, skrzynki, puste pola,bobmy, oraz powerupy\n" +
                        "Każdy gracz może kłaść bomby, ilość ich zależy od ich limitu bomb, a zasięg rażenia eksplozji od statystki siły\n" +
                        "Ekslpozja bomby rozwala skrzynki i zniszcalne ściany (maksymalnie jedną) oraz zabija graczy w każdym kierunku\n" +
                        "Po rozwaleniu skrzynki można znaleść powerupy które dają prędkosć poruszania postaci, dodatkowe bomby czy siłe bomb\n" +
                        "Rozwalenia ścian ma 20% szans znalezienia w nich skrzynki\n" +
                        "\n\n\n\n\nProjekt wykonany przez:\n Dawid Kostrzewa 240711\n Magdalena Kozłowska 240715\n Julia Śnieg 24818",16);

    }

    public void loadControls(){
        GameScene mapSelection = new GameScene("controls");
        mapSelection.backgroundColor = Color.BEIGE;

        GameObject fourth = new GameObject("StartGame",mapSelection);
        fourth.components.sprite = new Sprite(new Vector2(),new Vector2(600,150), "start.png");
        fourth.position = new Vector2(500, 650
        );
        fourth.components.script = new MenuButtonsScript();
        fourth.components.click = true;

        GameObject kapelutek = new GameObject("kapelutek",mapSelection);
        kapelutek.components.sprite=new Sprite(new Vector2(300,50),new Vector2(1000,562),"controls.png");

    }

}
