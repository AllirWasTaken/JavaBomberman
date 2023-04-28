package PingPong;

import AllirEngine.Components.Script;
import AllirEngine.Vector2;

public class BallScript extends Script {


    public Vector2 speed;

    @Override
    public void Update() {
        thisGameObject.position.x+=speed.x;
        thisGameObject.position.y+=speed.y;
        if(thisGameObject.position.x<-100||thisGameObject.position.x>1800){
            started=false;
            ((BallColision) thisGameObject.components.physicalBody).lastTouch=null;
        }
    }

    @Override
    public void Start() {
        speed = new Vector2(3,0);
        thisGameObject.position=new Vector2(800,450);
    }

    @Override
    public void OnClick() {

    }

    @Override
    public void OnHover() {

    }
}
