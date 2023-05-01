package TestingPackage;

import javafx.scene.input.KeyCode;
import AllirEngine.Components.Script;
import AllirEngine.Input;

public class TestScript extends Script {



    public int player;
    boolean visibility=true;
    boolean replaced=false;
    boolean photo=true;
    @Override
    public void Update() {
    if(player==1) {
        if (Input.GetKeyDown(KeyCode.W)) thisGameObject.position.y -= 5;
        if (Input.GetKeyDown(KeyCode.S)) thisGameObject.position.y += 5;
        if (Input.GetKeyDown(KeyCode.A)) thisGameObject.position.x -= 5;
        if (Input.GetKeyDown(KeyCode.D)) thisGameObject.position.x += 5;
    }
    else if(player==2){
        if (Input.GetKeyDown(KeyCode.UP)) thisGameObject.position.y -= 10;
        if (Input.GetKeyDown(KeyCode.DOWN)) thisGameObject.position.y += 10;
        if (Input.GetKeyDown(KeyCode.LEFT)) thisGameObject.position.x -= 10;
        if (Input.GetKeyDown(KeyCode.RIGHT)) thisGameObject.position.x += 10;
    }


    if(replaced){
        replaced=false;
    }
    else{
        if(!photo){
            thisGameObject.components.sprite.ReplaceSprite("Akira.png");
            photo=true;
        }
    }

    if(thisGameObject.clicked){
        if(visibility){
            visibility=false;
            thisGameObject.components.sprite.MakeSpriteInvisible();
        }
        else{
            visibility=true;
            thisGameObject.components.sprite.MakeSpriteVisible();
        }
    }
    if(thisGameObject.hoveredOver){
        if(photo){
            thisGameObject.components.sprite.ReplaceSprite("ShibaAAA.png");
            photo=false;
        }
        replaced=true;
    }



    }

    @Override
    public void Start() {

    }

}
