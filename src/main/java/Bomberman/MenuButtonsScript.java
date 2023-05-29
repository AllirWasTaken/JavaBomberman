package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;
import AllirEngine.GameScene;


public class MenuButtonsScript extends Script {

    @Override
    public void Update() {
        if(thisGameObject.clicked){
            if(thisGameObject.name.equals("startButton")){
                GameScene clickStart = new GameScene("Start");
                GameManager.SwitchScene("Start");
            }
            if(thisGameObject.name.equals("aboutButton")){
                GameScene clickAbout = new GameScene("About");
                GameManager.SwitchScene("About");
            }
            if(thisGameObject.name.equals("exitButton")){
                GameManager.ShutDownGame();
            }
        }
    }

    @Override
    public void Start() {

    }
}
