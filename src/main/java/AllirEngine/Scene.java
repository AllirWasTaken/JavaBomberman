package AllirEngine;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    public  List<GameObject> gameObjects;
    public String nameOfScene;
    public int width;
    public int height;
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


    public Scene(String name,int width,int height){
        gameObjects=new ArrayList<>();
        this.width=width;
        this.height=height;
        this.nameOfScene=name;
        GameManager.AddScene(this);
    }


    public void AddGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

}
