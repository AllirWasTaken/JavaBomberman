package AllirEngine;

public class GameObject {
    public Component components;

    public GameObject(){
        GameManager.GetCurrentScene().AddGameObject(this);
        components=new Component();
    }


}
