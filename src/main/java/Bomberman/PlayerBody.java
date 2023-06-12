package Bomberman;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class PlayerBody extends PhysicalBody {

    public PlayerBody(Vector2 relative, Vector2 Size){
        PassTroughPhysicalBodies=false;
        DetectColisions=true;
        relativePosition=relative;
        size=Size;
    }
    @Override
    public void OnColision(GameObject gameObject) {

    }
}
