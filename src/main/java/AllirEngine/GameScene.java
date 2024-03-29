package AllirEngine;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameScene {

    public  List<GameObject> gameObjects;
    public String nameOfScene;
    public Color backgroundColor;

    public GameObject GetGameObject(int i){
        if(i>=gameObjects.size()||i<0)return null;
        return gameObjects.get(i);

    }
    public GameObject GetGameObject(String nameOfGameObject){
        if(nameOfGameObject==null)return null;
        for(int i=0;i<gameObjects.size();i++){
            if(nameOfGameObject.equals(GetGameObject(i).name)){
                return GetGameObject(i);
            }
        }
        return null;
    }


    public GameScene(String name){
        gameObjects=new ArrayList<>();
        this.nameOfScene=name;
        backgroundColor=Color.BLACK;
        GameManager.AddScene(this);
    }


    public void AddGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

}
