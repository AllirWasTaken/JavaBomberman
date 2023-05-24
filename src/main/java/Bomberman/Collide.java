package Bomberman;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class Collide extends PhysicalBody {

    Collide(){
        this.size = new Vector2(100,100);
        this.relativePosition = new Vector2();
    }
    @Override
    public void OnColision(GameObject gameObject) {
        GameManager.ShutDownGame();
    }
}
