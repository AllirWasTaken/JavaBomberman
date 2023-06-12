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
                gameLoader.ReloadMap(MapManager.currentMap,"map"+MapManager.currentMap+".txt");
            }
            if(thisGameObject.name.equals("SoundButton")){
                if(GameManager.playSound){
                    GameManager.playSound=false;
                    thisGameObject.components.sprite.ReplaceSprite("soundOff.png");
                }
                else{
                    GameManager.playSound=true;
                    thisGameObject.components.sprite.ReplaceSprite("soundOn.png");
                }
            }
            if(thisGameObject.name.equals("BackToMenuLite")){
                GameManager.SwitchScene("Menu");
            }
            if(thisGameObject.name.equals("MusicButton")){
                if(GameManager.playMusic){
                    GameManager.playMusic=false;
                    thisGameObject.components.sprite.ReplaceSprite("musicOff.png");
                }
                else{
                    GameManager.playMusic=true;
                    thisGameObject.components.sprite.ReplaceSprite("musicOn.png");
                }
            }
        }
    }

    @Override
    public void Start() {
        if(thisGameObject.name.equals("SoundButton")){
            if(GameManager.playSound){
                thisGameObject.components.sprite.ReplaceSprite("soundOn.png");
            }
            else{
                thisGameObject.components.sprite.ReplaceSprite("soundOff.png");
            }

        }
        if(thisGameObject.name.equals("MusicButton")){
            if(GameManager.playMusic){
                thisGameObject.components.sprite.ReplaceSprite("musicOn.png");
            }
            else{
                thisGameObject.components.sprite.ReplaceSprite("musicOff.png");
            }
        }
    }
}
