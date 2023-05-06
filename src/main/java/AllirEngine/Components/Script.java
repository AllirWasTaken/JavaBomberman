package AllirEngine.Components;

import AllirEngine.GameObject;
import AllirEngine.GameScene;

public abstract class Script {
     public abstract void Update();
     public abstract void Start();
     public boolean started=false;
     public GameObject thisGameObject;
     public GameScene thisGameScene;

}
