package Bomberman;

import AllirEngine.Components.Script;

public class TestScript extends Script {

    int i=0;

    @Override
    public void Update() {
        if (i < 100){
            System.out.println("I updated!" + i);
            i++;
        }
    }

    @Override
    public void Start() {
        System.out.println("I Started!");
    }
}
