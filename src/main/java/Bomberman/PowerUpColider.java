package Bomberman;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class PowerUpColider extends PhysicalBody {
    int type;
    public PowerUpColider(int type){
        this.type=type;
        this.relativePosition=new Vector2(15,15);
        this.size=new Vector2(20,20);
    }

    @Override
    public void OnColision(GameObject gameObject) {
        if(gameObject.name.equals("Character")) {
            if (type == 1) ((PlayerControl) gameObject.components.script).IncreaseSpeed();
            if (type == 2) ((PlayerControl) gameObject.components.script).bombCount++;
            if (type == 3) ((PlayerControl) gameObject.components.script).bombStrength++;
            GameManager.Destroy(thisGameObject);
        }
    }
}
