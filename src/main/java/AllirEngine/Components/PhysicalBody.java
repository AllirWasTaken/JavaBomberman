package AllirEngine.Components;

import AllirEngine.Vector2;
import AllirEngine.*;

public abstract class PhysicalBody {
    public GameObject thisGameObject;
    public GameScene thisGameScene;
    public Vector2 relativePosition;
    public Vector2 lastPosition;
    public Vector2 size;
    public Vector2 RepulsionCorrection;
    public boolean HardRepulsion=false;
    public boolean PassTroughPhysicalBodies=true;
    public boolean DetectColisions=false;

    public abstract void OnColision(GameObject gameObject);


}
