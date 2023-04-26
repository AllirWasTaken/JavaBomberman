package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameManager;

public class TestScript extends Script {

    int i;

    @Override
    public void Update() {
        i++;
        if(i>=1){
            i=0;
            thisGameObject.position.x+=1;
            thisGameObject.position.y+=1;
        }
    }

    @Override
    public void Start() {
        System.out.println("I Started!");
    }
}
