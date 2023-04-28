package AllirEngine.Components;

import AllirEngine.Vector2;
import AllirEngine.*;

public abstract class PhysicalBody {
    public GameObject thisGameObject;
    public GameScene thisGameScene;
    public Vector2 relativePosition;
    public Vector2 size;
    public boolean PassTroughPhysicalBodies;

    public abstract void OnColision(GameObject gameObject);


}
