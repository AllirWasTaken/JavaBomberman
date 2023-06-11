package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sprite;
import AllirEngine.Components.TextSprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;
import javafx.scene.paint.Color;

public class UIScript extends Script {
    int time;

    int timeSec;
    int timeMin;
    boolean gameEnd;

    int timeCounter=0;

    GameObject timer,bomb,exp,speed,player;

    @Override
    public void Update() {
        if(!gameEnd) {
            timeCounter++;
            if (timeCounter == 60) {
                time++;
                timeSec = time % 60;
                timeMin = time / 60;
                timeCounter = 0;
                if (timeSec < 10) {
                    timer.components.textSprite.ChangeText("TIME\n" + timeMin + ":0" + timeSec);
                } else {
                    timer.components.textSprite.ChangeText("TIME\n" + timeMin + ":" + timeSec);
                }

            }
            for (int i = 1; i < 4; i++) {
                bomb = GameManager.GetCurrentScene().GetGameObject("bombText" + (i));
                exp = GameManager.GetCurrentScene().GetGameObject("strengthText" + (i));
                speed = GameManager.GetCurrentScene().GetGameObject("speedText" + (i));
                player = GameManager.GetCurrentScene().GetGameObject("Character" + (i));

                bomb.components.textSprite.ChangeText("BOMBS:" + ((PlayerControl) player.components.script).bombInPocket + "/" + ((PlayerControl) player.components.script).bombCount);
                speed.components.textSprite.ChangeText("SPEED:" + ((PlayerControl) player.components.script).speed);
                exp.components.textSprite.ChangeText("STRENGTH:" + ((PlayerControl) player.components.script).bombStrength);

            }

            int control = 0;
            if (MapManager.p1) control++;
            if (MapManager.p2) control++;
            if (MapManager.p3) control++;

            if (control <= 1) {
                MapManager.run = false;
                gameEnd = true;
                GameObject canvas = new GameObject("canvas");
                canvas.position = new Vector2(500, 300);
                canvas.components.sprite = new Sprite(new Vector2(), new Vector2(600, 300), "back.png");

                String text;
                if (MapManager.p1) text = "PLAYER1 WINS!!";
                else if (MapManager.p2) text = "PLAYER2 WINS!!";
                else if (MapManager.p3) text = "PLAYER3 WINS!!";
                else text = "NOONE WINS :C";

                GameObject textWin = new GameObject("text");
                textWin.position = new Vector2(510, 300);
                textWin.components.textSprite = new TextSprite(new Vector2(0, 50), text, 50);

                GameObject button = new GameObject("BackToMenu");

                button.position = new Vector2(750, 490);
                button.components.sprite = new Sprite(new Vector2(-50,-110), new Vector2(200, 200), "ExitToMenu.png");
                button.components.script = new UIButtonsScript();
                button.components.click = true;


            }
        }
    }

    @Override
    public void Start() {
        timer= GameManager.GetCurrentScene().GetGameObject("timer");
        gameEnd=false;

    }
}
