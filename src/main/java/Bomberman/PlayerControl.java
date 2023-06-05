package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sprite;
import AllirEngine.GameObject;
import AllirEngine.Input;
import AllirEngine.Vector2;
import javafx.scene.input.KeyCode;

public class PlayerControl extends Script {
    public int player;
    @Override
    public void Update() {
        if(player==1) {
            if (Input.GetKeyDown(KeyCode.W)) thisGameObject.position.y -= 5;
            if (Input.GetKeyDown(KeyCode.S)) thisGameObject.position.y += 5;
            if (Input.GetKeyDown(KeyCode.A)) thisGameObject.position.x -= 5;
            if (Input.GetKeyDown(KeyCode.D)) thisGameObject.position.x += 5;

        }
        else if(player==2){
            if (Input.GetKeyDown(KeyCode.UP)) thisGameObject.position.y -= 5;
            if (Input.GetKeyDown(KeyCode.DOWN)) thisGameObject.position.y += 5;
            if (Input.GetKeyDown(KeyCode.LEFT)) thisGameObject.position.x -= 5;
            if (Input.GetKeyDown(KeyCode.RIGHT)) thisGameObject.position.x += 5;
            if(Input.GetKeyDown(KeyCode.SPACE))SpawnBomb();
        }
    }

    @Override
    public void Start() {

    }
    public void SpawnBomb(){
        GameObject newBomb=new GameObject("Bomb");
        newBomb.position=new Vector2(thisGameObject.position.x+10,thisGameObject.position.y+10);
        newBomb.components.sprite=new Sprite(new Vector2(),new Vector2(40,40),"bomb.png");
        newBomb.components.script=new BombScript(5);
    }
}
