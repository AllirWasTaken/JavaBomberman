package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;
import AllirEngine.GameScene;


public class MenuButtonsScript extends Script {

    @Override
    public void Update() {
        if(thisGameObject.clicked){
            if(thisGameObject.name.equals("startButton")){
                GameManager.SwitchScene("mapSelection");
            }
            if(thisGameObject.name.equals("aboutButton")){
                GameManager.SwitchScene("About");
            }
            if(thisGameObject.name.equals("exitButton")){
                GameManager.ShutDownGame();
            }
            if(thisGameObject.name.equals("Multiplayer")){
                GameManager.SwitchScene("mapSelection");
            }
            if(thisGameObject.name.equals("firstMap")){
                MapManager.currentMap=1;
                GameManager.SwitchScene("controls");
            }
            if(thisGameObject.name.equals("secondMap")){
                MapManager.currentMap=2;
                GameManager.SwitchScene("controls");
            }
            if(thisGameObject.name.equals("thirdMap")){
                MapManager.currentMap=3;
                GameManager.SwitchScene("controls");
            }
            if(thisGameObject.name.equals("fourthMap")){
                MapManager.currentMap=4;
                GameManager.SwitchScene("controls");
            }
            if(thisGameObject.name.equals("StartGame")){
                GameManager.SwitchScene("Map"+MapManager.currentMap);
                MapManager.p1=true;
                MapManager.p2=true;
                MapManager.p3=true;
                MapManager.run=true;
            }
        }
    }

    @Override
    public void Start() {

    }
}
