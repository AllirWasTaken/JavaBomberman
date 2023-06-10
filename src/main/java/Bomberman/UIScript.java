package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;
import AllirEngine.GameObject;

public class UIScript extends Script {
    int time;

    int timeSec;
    int timeMin;

    int timeCounter=0;

    GameObject timer;

    @Override
    public void Update() {
        timeCounter++;
        if(timeCounter==60){
            time++;
            timeSec=time%60;
            timeMin=time/60;
            timeCounter=0;
            if(timeSec<10){
                timer.components.textSprite.ChangeText(timeMin+":0"+timeSec);
            }
            else{
                timer.components.textSprite.ChangeText(timeMin+":"+timeSec);
            }

        }
    }

    @Override
    public void Start() {
        timer= GameManager.GetCurrentScene().GetGameObject("timer");
    }
}
