package TestingPackage;

import javafx.scene.input.KeyCode;
import AllirEngine.Components.Script;
import AllirEngine.Input;

public class TestScript extends Script {



    public int player;

    @Override
    public void Update() {
    if(player==1) {
        if (Input.GetKeyDown(KeyCode.W)) thisGameObject.position.y -= 5;
        if (Input.GetKeyDown(KeyCode.S)) thisGameObject.position.y += 5;
        if (Input.GetKeyDown(KeyCode.A)) thisGameObject.position.x -= 5;
        if (Input.GetKeyDown(KeyCode.D)) thisGameObject.position.x += 5;
    }
    else if(player==2){
        if (Input.GetKeyDown(KeyCode.UP)) thisGameObject.position.y -= 10;
        if (Input.GetKeyDown(KeyCode.DOWN)) thisGameObject.position.y += 10;
        if (Input.GetKeyDown(KeyCode.LEFT)) thisGameObject.position.x -= 10;
        if (Input.GetKeyDown(KeyCode.RIGHT)) thisGameObject.position.x += 10;
    }
    }

    @Override
    public void Start() {

    }

    @Override
    public void OnClick() {
        System.out.println("Akira has been clicked");
    }

    @Override
    public void OnHover() {
        System.out.println("Akira is getting pointed at");
    }
}
