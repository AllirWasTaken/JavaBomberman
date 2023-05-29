package SampleScene;
import AllirEngine.*;


public class MainSample {
    public static void main(String[] args) {
        GameManager.Initialize(args,900,900,1600,900);
        SceneManagerScript man = new SceneManagerScript();
        man.start();
        GameManager.LaunchGame();
    }
}
