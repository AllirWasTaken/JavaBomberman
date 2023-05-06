package TestingPackage;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class TestColider extends PhysicalBody {
    public TestColider(Vector2 relativePosition,Vector2 size){
        this.relativePosition=relativePosition;
        this.size=size;
    }
    @Override
    public void OnColision(GameObject gameObject) {
        GameManager.ShutDownGame();
    }
}
