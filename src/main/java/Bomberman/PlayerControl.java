package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sprite;
import AllirEngine.GameObject;
import AllirEngine.Input;
import AllirEngine.Vector2;
import javafx.scene.input.KeyCode;

public class PlayerControl extends Script {
    public int player;
    int currentDirection=1;
    boolean moving=false;
    boolean wasMoving=false;
    boolean changedDirection=false;
    int speed=4;
    int gridX,gridY;
    @Override
    public void Update() {
        gridX=((int)thisGameObject.position.x+25)/50;
        gridY=((int)thisGameObject.position.y-75)/50;
        wasMoving=moving;
        moving=false;
        changedDirection=false;
        if(player==1) {
            if (Input.GetKeyDown(KeyCode.W)) thisGameObject.position.y -= speed;
            if (Input.GetKeyDown(KeyCode.S)) thisGameObject.position.y += speed;
            if (Input.GetKeyDown(KeyCode.A)) thisGameObject.position.x -= speed;
            if (Input.GetKeyDown(KeyCode.D)) thisGameObject.position.x += speed;

        }
        else if(player==2){
            if (Input.GetKeyDown(KeyCode.UP)){
                thisGameObject.position.y -= speed;
                if(currentDirection!=0)changedDirection=true;
                currentDirection=0;
                moving=true;
            }
            else if (Input.GetKeyDown(KeyCode.DOWN)) {
                if(currentDirection!=2)changedDirection=true;
                currentDirection=2;
                thisGameObject.position.y += speed;
                moving=true;
            }
            else if (Input.GetKeyDown(KeyCode.LEFT)){
                if(currentDirection!=3)changedDirection=true;
                currentDirection=3;
                thisGameObject.position.x -= speed;
                moving=true;
            }
            else if (Input.GetKeyDown(KeyCode.RIGHT)) {
                if(currentDirection!=1)changedDirection=true;
                currentDirection=1;
                thisGameObject.position.x += speed;
                moving=true;
            }
            if(Input.GetKeyDown(KeyCode.SPACE))SpawnBomb();

            if(moving&&(!wasMoving||changedDirection)){
                if(currentDirection==0)thisGameObject.components.animationModule.Play("GoUp");
                if(currentDirection==1)thisGameObject.components.animationModule.Play("GoRight");
                if(currentDirection==2)thisGameObject.components.animationModule.Play("GoDown");
                if(currentDirection==3)thisGameObject.components.animationModule.Play("GoLeft");
            }
            if(!moving) thisGameObject.components.animationModule.Stop();
        }
    }

    @Override
    public void Start() {
        thisGameObject.components.animationModule.Play("GoRight");
    }
    public void SpawnBomb(){
        if(MapManager.GetTile(MapManager.currentMap,gridX,gridY)==TileTypes.empty) {
            GameObject newBomb = new GameObject("Bomb");
            newBomb.position = new Vector2(gridX*50+5, gridY*50 + 100+5);
            newBomb.components.sprite = new Sprite(new Vector2(), new Vector2(40, 40), "bomb.png");
            newBomb.components.script = new BombScript(5,gridX,gridY);
            MapManager.SetTile(TileTypes.bomb,MapManager.currentMap,gridX,gridY);
            MapManager.SetObject(newBomb,MapManager.currentMap,gridX,gridY);
        }
    }
}
