package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sprite;
import AllirEngine.GameObject;
import AllirEngine.Input;
import AllirEngine.Vector2;
import javafx.scene.input.KeyCode;

public class PlayerControl extends Script {
    public int player;
    int currentDirection=1;
    boolean moving=false;
    boolean wasMoving=false;
    boolean changedDirection=false;
    int speed=3;
    @Override
    public void Update() {
        wasMoving=moving;
        moving=false;
        changedDirection=false;
        if(player==1) {
            if (Input.GetKeyDown(KeyCode.W)) thisGameObject.position.y -= speed;
            if (Input.GetKeyDown(KeyCode.S)) thisGameObject.position.y += speed;
            if (Input.GetKeyDown(KeyCode.A)) thisGameObject.position.x -= speed;
            if (Input.GetKeyDown(KeyCode.D)) thisGameObject.position.x += speed;

        }
        else if(player==2){
            if (Input.GetKeyDown(KeyCode.UP)){
                thisGameObject.position.y -= speed;
                if(currentDirection!=0)changedDirection=true;
                currentDirection=0;
                moving=true;
            }
            if (Input.GetKeyDown(KeyCode.DOWN)) {
                if(currentDirection!=2)changedDirection=true;
                currentDirection=2;
                thisGameObject.position.y += speed;
                moving=true;
            }
            if (Input.GetKeyDown(KeyCode.LEFT)){
                if(currentDirection!=3)changedDirection=true;
                currentDirection=3;
                thisGameObject.position.x -= speed;
                moving=true;
            }
            if (Input.GetKeyDown(KeyCode.RIGHT)) {
                if(currentDirection!=1)changedDirection=true;
                currentDirection=1;
                thisGameObject.position.x += speed;
                moving=true;
            }
            if(Input.GetKeyDown(KeyCode.SPACE))SpawnBomb();

            if(moving&&(!wasMoving||changedDirection)){
                if(currentDirection==0)thisGameObject.components.animationModule.Play("GoUp");
                if(currentDirection==1)thisGameObject.components.animationModule.Play("GoRight");
                if(currentDirection==2)thisGameObject.components.animationModule.Play("GoDown");
                if(currentDirection==3)thisGameObject.components.animationModule.Play("GoLeft");
            }
            if(!moving) thisGameObject.components.animationModule.Stop();
        }
    }

    @Override
    public void Start() {
        thisGameObject.components.animationModule.Play("GoRight");
    }
    public void SpawnBomb(){
        GameObject newBomb=new GameObject("Bomb");
        newBomb.position=new Vector2(thisGameObject.position.x+10,thisGameObject.position.y+10);
        newBomb.components.sprite=new Sprite(new Vector2(),new Vector2(40,40),"bomb.png");
        newBomb.components.script=new BombScript(5);
    }
}
