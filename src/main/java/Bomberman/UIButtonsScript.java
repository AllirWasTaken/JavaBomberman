package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;

public class UIButtonsScript extends Script {
    @Override
    public void Update() {
        if(thisGameObject.clicked){
            if(thisGameObject.name.equals("BackToMenu")){
                GameManager.SwitchScene("Menu");
                GameLoader gameLoader = new GameLoader();
                gameLoader.ReloadMap(MapManager.currentMap,"Map"+MapManager.currentMap);
            }
        }
    }

    @Override
    public void Start() {

    }
}
