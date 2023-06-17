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
    //playerVariables
    int speed=3;
    int bombStrength=1;
    int bombCount=2;
    int bombInPocket=1;
    int bombCoolDown=0;
    int notMovingCounter=0;
    int gridX,gridY;
    KeyCode upKey,downKey,rightKey,leftKey,bombKey;
    @Override
    public void Update() {



        if(bombCount==bombInPocket)bombCoolDown=180;
        if(bombCoolDown==0){
            if(bombInPocket<bombCount){
                bombInPocket++;
                bombCoolDown=180/bombCount;
            }
        }
        else bombCoolDown--;


        gridX=((int)thisGameObject.position.x+25)/50;
        gridY=((int)thisGameObject.position.y-75)/50;
        wasMoving=moving;
        moving=false;
        changedDirection=false;

        if(MapManager.run&&((player==1&&MapManager.p1)||(player==2&&MapManager.p2)||(player==3&&MapManager.p3))) {
            if (Input.GetKeyDown(upKey)) {
                thisGameObject.position.y -= speed;
                if (currentDirection != 0) changedDirection = true;
                currentDirection = 0;
                moving = true;
            } else if (Input.GetKeyDown(downKey)) {
                if (currentDirection != 2) changedDirection = true;
                currentDirection = 2;
                thisGameObject.position.y += speed;
                moving = true;
            } else if (Input.GetKeyDown(leftKey)) {
                if (currentDirection != 3) changedDirection = true;
                currentDirection = 3;
                thisGameObject.position.x -= speed;
                moving = true;
            } else if (Input.GetKeyDown(rightKey)) {
                if (currentDirection != 1) changedDirection = true;
                currentDirection = 1;
                thisGameObject.position.x += speed;
                moving = true;
            }
            if (Input.GetKeyDown(bombKey)) {
                if (bombInPocket > 0) {
                    SpawnBomb();

                }
            }
        }

        if(MapManager.run) {
            if (moving) notMovingCounter = 0;
            else notMovingCounter++;
            if (notMovingCounter == 1200) {
                notMovingCounter = 0;
                Kill();
            }
        }
        if(moving&&(!wasMoving||changedDirection)){
            if(currentDirection==0)thisGameObject.components.animationModule.Play("GoUp");
            if(currentDirection==1)thisGameObject.components.animationModule.Play("GoRight");
            if(currentDirection==2)thisGameObject.components.animationModule.Play("GoDown");
            if(currentDirection==3)thisGameObject.components.animationModule.Play("GoLeft");
        }
        if(!moving) thisGameObject.components.animationModule.Stop();
    }


    @Override
    public void Start() {
        if(player==1){
            upKey=KeyCode.W;
            downKey=KeyCode.S;
            leftKey=KeyCode.A;
            rightKey=KeyCode.D;
            bombKey=KeyCode.Q;
        }
        if(player==2){
            upKey=KeyCode.I;
            downKey=KeyCode.K;
            leftKey=KeyCode.J;
            rightKey=KeyCode.L;
            bombKey=KeyCode.U;
        }
        if(player==3){
            upKey=KeyCode.UP;
            downKey=KeyCode.DOWN;
            leftKey=KeyCode.LEFT;
            rightKey=KeyCode.RIGHT;
            bombKey=KeyCode.ENTER;
        }
    }
    public void SpawnBomb(){
        if(MapManager.GetTile(MapManager.currentMap,gridX,gridY)==TileTypes.empty) {
            bombInPocket--;
            GameObject newBomb = new GameObject("Bomb");
            newBomb.position = new Vector2(gridX*50+5, gridY*50 + 100+5);
            newBomb.components.sprite = new Sprite(new Vector2(), new Vector2(40, 40), "bomb.png");
            newBomb.components.script = new BombScript(bombStrength,gridX,gridY);
            MapManager.SetTile(TileTypes.bomb,MapManager.currentMap,gridX,gridY);
            MapManager.SetObject(newBomb,MapManager.currentMap,gridX,gridY);
        }
    }

    public void IncreaseSpeed(){
        if(speed==10)return;
        speed++;
        int newDelay=-1;
        if(speed==3) newDelay=8;
        if(speed==4) newDelay=6;
        if(speed==5) newDelay=5;
        if(speed==6) newDelay=3;


        if(newDelay!=-1) {
            for (int i = 0; i < 4; i++) {
                thisGameObject.components.animationModule.animationList.get(i).framesDelay = newDelay;
            }
        }
    }

    public void Kill(){
        thisGameObject.components.sprite.MakeSpriteInvisible();
        if(player==1)MapManager.p1=false;
        if(player==2)MapManager.p2=false;
        if(player==3)MapManager.p3=false;
    }
}
