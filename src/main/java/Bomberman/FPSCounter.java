package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameTimer;

public class FPSCounter extends Script {
    String currentFPS;
    @Override
    public void Update() {
        currentFPS= "FPS: "+GameTimer.GetFps()+"\nFS: "+ GameTimer.GetFrameSkip();
        thisGameObject.components.textSprite.ChangeText(currentFPS);
    }

    @Override
    public void Start() {

    }
}
