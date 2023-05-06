package PingPong;

import AllirEngine.Components.PhysicalBody;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

import java.util.Random;

public class BallColision extends PhysicalBody {


    GameObject lastTouch;
    public BallColision(Vector2 relativePosition,Vector2 size){
        this.relativePosition=relativePosition;
        this.size=size;
    }
    @Override
    public void OnColision(GameObject gameObject) {
        if(thisGameObject.name.equals("ball")){
            if(lastTouch!=gameObject) {
                lastTouch=gameObject;
                if(gameObject.name.equals("wall1")||gameObject.name.equals("wall2")){
                    Vector2 temp = ((BallScript) thisGameObject.components.script).speed;
                    ((BallScript) thisGameObject.components.script).speed = new Vector2(temp.x, temp.y*-1);
                }
                else {
                    Vector2 temp = ((BallScript) thisGameObject.components.script).speed;

                    if (temp.x < 0) {
                        temp.x -= 2;
                        temp.x *= -1;
                    } else {
                        temp.x += 2;
                        temp.x *= -1;
                    }
                    Random rand = new Random();

                    temp.y += rand.nextInt(-5, 5);

                    ((BallScript) thisGameObject.components.script).speed = new Vector2(temp.x, temp.y);
                }
            }
        }
    }
}
