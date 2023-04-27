package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;

public class TestScript extends Script {



    @Override
    public void Update() {

            thisGameObject.position.x+=1;
            thisGameObject.position.y+=1;
    }

    @Override
    public void Start() {
        System.out.println("I Started!");
    }
}
