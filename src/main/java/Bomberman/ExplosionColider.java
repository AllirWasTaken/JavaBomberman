package Bomberman;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class ExplosionColider extends PhysicalBody {

    @Override
    public void OnColision(GameObject gameObject) {
        if(gameObject.name.equals("Character1")||gameObject.name.equals("Character2")||gameObject.name.equals("Character3")){
            ((PlayerControl) gameObject.components.script).Kill();
        }
    }

    public ExplosionColider(Vector2 relative){
        this.relativePosition=new Vector2(relative.x+5,relative.y+5);
        this.size=new Vector2(40,40);
    }
}
