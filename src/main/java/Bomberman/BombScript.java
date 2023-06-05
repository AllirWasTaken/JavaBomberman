package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class BombScript extends Script {
    int timeToExplode;
    int type;
    int range;
    BombScript(int range,int type){
        this.type=type;
        timeToExplode=300;
        this.range=range;
        if(type==1){
            timeToExplode=60;
        }
    }
    BombScript(int range){
        this.type=0;
        this.range=range;
        timeToExplode=300;
    }
    @Override
    public void Update() {
        if(timeToExplode==0){
           Explode();
        }
        else timeToExplode--;
    }

    @Override
    public void Start() {

    }

    public void Explode(){
        GameManager.RemoveSpriteFromScreen(thisGameObject.components.sprite.imageView);

        if(type==0){
            Vector2 thisPosition=new Vector2(thisGameObject.position.x,thisGameObject.position.y);
            thisPosition.x-=10;
            thisPosition.y-=10;
            GameObject explosionCenter = new GameObject("Explosion");
            explosionCenter.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y),new Vector2(50,50),"explosionCenter.png");
            explosionCenter.components.script=new BombScript(0,1);
            for(int i=1;i<range;i++){
                GameObject up = new GameObject("ExplosionU");
                up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*i),new Vector2(50,50),"explosionVertical.png");
                up.components.script=new BombScript(0,1);

                GameObject down = new GameObject("ExplosionD");
                down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*i),new Vector2(50,50),"explosionVertical.png");
                down.components.script=new BombScript(0,1);

                GameObject right = new GameObject("ExplosionR");
                right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*i,thisPosition.y),new Vector2(50,50),"explosionHorizontal.png");
                right.components.script=new BombScript(0,1);

                GameObject left = new GameObject("ExplosionL");
                left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*i,thisPosition.y),new Vector2(50,50),"explosionHorizontal.png");
                left.components.script=new BombScript(0,1);
            }
            GameObject up = new GameObject("ExplosionU");
            up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*range),new Vector2(50,50),"explosionEndUp.png");
            up.components.script=new BombScript(0,1);

            GameObject down = new GameObject("ExplosionD");
            down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*range),new Vector2(50,50),"explosionEndDown.png");
            down.components.script=new BombScript(0,1);

            GameObject right = new GameObject("ExplosionR");
            right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*range,thisPosition.y),new Vector2(50,50),"explosionEndRight.png");
            right.components.script=new BombScript(0,1);

            GameObject left = new GameObject("ExplosionL");
            left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*range,thisPosition.y),new Vector2(50,50),"explosionEndLeft.png");
            left.components.script=new BombScript(0,1);

        }
        GameManager.GetCurrentScene().gameObjects.remove(thisGameObject);
    }
}
