package PingPong;

import AllirEngine.Components.Script;
import AllirEngine.Input;
import javafx.scene.input.KeyCode;

public class PlayerScript extends Script {
    int player;
    int playerSpeed;
    PlayerScript(int player){
        this.player=player;
        playerSpeed=15;
    }
    @Override
    public void Update() {
        if(player==1){
            if(Input.GetKeyDown(KeyCode.W))thisGameObject.position.y-=playerSpeed;
            if(Input.GetKeyDown(KeyCode.S))thisGameObject.position.y+=playerSpeed;
        }
        else if(player==2){
            if(Input.GetKeyDown(KeyCode.UP))thisGameObject.position.y-=playerSpeed;
            if(Input.GetKeyDown(KeyCode.DOWN))thisGameObject.position.y+=playerSpeed;
        }
    }

    @Override
    public void Start() {

    }


}
