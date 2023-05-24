package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;
import AllirEngine.Input;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class BoxScript extends Script {

    @Override
    public void Update() {
        if(thisGameObject.hoveredOver){
            thisGameObject.components.sprite.color = Color.BLUE;
        }
        else{
            thisGameObject.components.sprite.color = Color.BEIGE;
        }
        if(thisGameObject.clicked){
            GameManager.SwitchScene("pusto");
        }
        if(Input.GetKeyDown(KeyCode.D)){
            thisGameObject.position.x++;
        }
    }

    @Override
    public void Start() {

    }
}
