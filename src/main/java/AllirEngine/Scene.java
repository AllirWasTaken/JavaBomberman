package AllirEngine;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    public  List<GameObject> gameObjects;
    public Scene(){
        gameObjects=new ArrayList<>();
        GameManager.AddScene(this);
    }


    public void AddGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

}
