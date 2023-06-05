package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;
import AllirEngine.GameScene;


public class MenuButtonsScript extends Script {

    @Override
    public void Update() {
        if(thisGameObject.clicked){
            if(thisGameObject.name.equals("startButton")){
                GameManager.SwitchScene("GameTypeSelection");
            }
            if(thisGameObject.name.equals("aboutButton")){
                GameScene clickAbout = new GameScene("About");
                GameManager.SwitchScene("About");
            }
            if(thisGameObject.name.equals("exitButton")){
                GameManager.ShutDownGame();
            }
            if(thisGameObject.name.equals("Multiplayer")){
                GameManager.SwitchScene("mapSelection");
            }
            if(thisGameObject.name.equals("firstMap")){
                GameManager.SwitchScene("Map1");
            }
        }
    }

    @Override
    public void Start() {

    }
}
