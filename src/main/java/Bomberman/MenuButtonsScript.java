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
                MapManager.currentMap=1;
            }
            if(thisGameObject.name.equals("secondMap")){
                GameManager.SwitchScene("Map2");
                MapManager.currentMap=2;
            }
            if(thisGameObject.name.equals("thirdMap")){
                GameManager.SwitchScene("Map3");
                MapManager.currentMap=3;
            }
            if(thisGameObject.name.equals("fourthMap")){
                GameManager.SwitchScene("Map4");
                MapManager.currentMap=4;
            }
        }
    }

    @Override
    public void Start() {

    }
}
