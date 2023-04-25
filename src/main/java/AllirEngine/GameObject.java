package AllirEngine;

public class GameObject {
    public Component components;
    public String name;
    Vector2 position;


    public GameObject(String name){
        this.name=name;
        components=new Component();
        position = new Vector2();
        GameManager.GetCurrentScene().AddGameObject(this);
    }


}
