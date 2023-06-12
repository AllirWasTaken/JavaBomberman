package Bomberman;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class EmptyColider extends PhysicalBody {

    public EmptyColider(Vector2 relative, Vector2 size){
        this.relativePosition=relative;
        this.size=size;
    }
    @Override
    public void OnColision(GameObject gameObject) {

    }
}
