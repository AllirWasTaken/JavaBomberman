package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.Components.Sound;
import AllirEngine.Components.Sprite;
import AllirEngine.GameManager;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

import java.util.Random;

public class BombScript extends Script {
    int timeToExplode;
    int type;
    int range;
    int gridX,gridY;
    BombScript(int range,int type){
        this.type=type;
        timeToExplode=300;
        this.range=range;
        if(type==1){
            timeToExplode=60;
        }
    }
    BombScript(int range,int gridX,int gridY){
        this.type=0;
        this.range=range;
        timeToExplode=180;
        this.gridX=gridX;
        this.gridY=gridY;
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
        thisGameObject.components.sound=new Sound("buum.mp3");
    }

    public void Explode(){

        Random rand = new Random();



        if(type==0){
            MapManager.SetTile(TileTypes.empty,MapManager.currentMap,gridX,gridY);
            MapManager.SetObject(null,MapManager.currentMap,gridX,gridY);
            thisGameObject.components.sound.PlaySound();
            Vector2 thisPosition=new Vector2(thisGameObject.position.x,thisGameObject.position.y);
            thisPosition.x-=5;
            thisPosition.y-=5;
            GameObject explosionCenter = new GameObject("Explosion");
            explosionCenter.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y),new Vector2(50,50),"explosionCenter.png");
            explosionCenter.components.script=new BombScript(0,1);

            for(int i=0;i<range;i++) {
                GameObject right = new GameObject("ExplosionU");
                right.components.script=new BombScript(0,1);
                if(MapManager.GetTile(MapManager.currentMap,gridX+1+i,gridY)==TileTypes.wallDe){
                    GameObject wall=MapManager.GetObject(MapManager.currentMap,gridX+1+i,gridY);
                    GameManager.Destroy(wall);
                    if(rand.nextInt(0,5)==0){
                        GameObject newChest=new GameObject("Chest");
                        newChest.position=new Vector2(thisPosition.x+50*(i+1),thisPosition.y);
                        newChest.components.sprite=new Sprite(new Vector2(5,5),new Vector2(40,40),"chest.png");
                        MapManager.SetTile(TileTypes.chest, MapManager.currentMap, gridX + 1 + i, gridY);
                        MapManager.SetObject(newChest, MapManager.currentMap, gridX + 1 + i, gridY);
                    }
                    else {
                        MapManager.SetTile(TileTypes.empty, MapManager.currentMap, gridX + 1 + i, gridY);
                        MapManager.SetObject(null, MapManager.currentMap, gridX + 1 + i, gridY);
                    }
                    right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*(i+1),thisPosition.y),new Vector2(50,50),"explosionEndRight.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX+1+i,gridY)==TileTypes.chest){
                    GameObject powerUp=new GameObject("powerUp");
                    powerUp.position=new Vector2(thisPosition.x+50*(i+1),thisPosition.y);

                    int a =rand.nextInt(0,3);
                    if(a==0)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerSpeed.png");
                    if(a==1)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerBomb.png");
                    if(a==2)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerExplosion.png");
                    powerUp.components.physicalBody=new PowerUpColider(a+1);
                    MapManager.SetTile(TileTypes.empty,MapManager.currentMap,gridX+1+i,gridY);
                    GameManager.Destroy(MapManager.GetObject(MapManager.currentMap,gridX+1+i,gridY));
                    MapManager.SetObject(null,MapManager.currentMap,gridX+1+i,gridY);

                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX+1+i,gridY)==TileTypes.wallIn){
                    if(i==0)break;
                    right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*i,thisPosition.y),new Vector2(50,50),"explosionEndRight.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX+1+i,gridY)==TileTypes.bomb){
                    ((BombScript) MapManager.GetObject(MapManager.currentMap, gridX+1+i,gridY).components.script).timeToExplode=1;
                }
                if(i+1==range){
                    right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*(i+1),thisPosition.y),new Vector2(50,50),"explosionEndRight.png");
                    break;
                }
                right.components.sprite = new Sprite(new Vector2(thisPosition.x+50*(i+1),thisPosition.y),new Vector2(50,50),"explosionHorizontal.png");
            }
            for(int i=0;i<range;i++) {
                GameObject up = new GameObject("ExplosionU");
                up.components.script=new BombScript(0,1);
                if(MapManager.GetTile(MapManager.currentMap,gridX,gridY+1+i)==TileTypes.wallDe){
                    GameObject wall=MapManager.GetObject(MapManager.currentMap,gridX,gridY+1+i);
                    GameManager.Destroy(wall);
                    if(rand.nextInt(0,5)==0){
                        GameObject newChest=new GameObject("Chest");
                        newChest.position=new Vector2(thisPosition.x,thisPosition.y+50*(i+1));
                        newChest.components.sprite=new Sprite(new Vector2(5,5),new Vector2(40,40),"chest.png");
                        MapManager.SetTile(TileTypes.chest, MapManager.currentMap, gridX, gridY+1+i);
                        MapManager.SetObject(newChest, MapManager.currentMap, gridX, gridY+1+i);
                    }
                    else {
                        MapManager.SetTile(TileTypes.empty, MapManager.currentMap, gridX, gridY+1+i);
                        MapManager.SetObject(null, MapManager.currentMap, gridX, gridY+1+i);
                    }
                    up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*(i+1)),new Vector2(50,50),"explosionEndDown.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY+1+i)==TileTypes.chest){
                    GameObject powerUp=new GameObject("powerUp");
                    powerUp.position=new Vector2(thisPosition.x,thisPosition.y+50*(i+1));

                    int a =rand.nextInt(0,3);
                    if(a==0)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerSpeed.png");
                    if(a==1)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerBomb.png");
                    if(a==2)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerExplosion.png");
                    powerUp.components.physicalBody=new PowerUpColider(a+1);
                    MapManager.SetTile(TileTypes.empty,MapManager.currentMap,gridX, gridY+1+i);
                    GameManager.Destroy(MapManager.GetObject(MapManager.currentMap,gridX, gridY+1+i));
                    MapManager.SetObject(null,MapManager.currentMap,gridX, gridY+1+i);
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY+1+i)==TileTypes.wallIn){
                    if(i==0)break;
                    up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*i),new Vector2(50,50),"explosionEndDown.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY+1+i)==TileTypes.bomb){
                    ((BombScript) MapManager.GetObject(MapManager.currentMap, gridX+1+i,gridY).components.script).timeToExplode=1;
                }
                if(i+1==range){
                    up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*(i+1)),new Vector2(50,50),"explosionEndDown.png");
                    break;
                }
                up.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y+50*(i+1)),new Vector2(50,50),"explosionVertical.png");
            }
            for(int i=0;i<range;i++) {
                GameObject left = new GameObject("ExplosionU");
                left.components.script=new BombScript(0,1);
                if(MapManager.GetTile(MapManager.currentMap,gridX-1-i,gridY)==TileTypes.wallDe){
                    GameObject wall=MapManager.GetObject(MapManager.currentMap,gridX-1-i,gridY);
                    GameManager.Destroy(wall);
                    if(rand.nextInt(0,5)==0){
                        GameObject newChest=new GameObject("Chest");
                        newChest.position=new Vector2(thisPosition.x-50*(i+1),thisPosition.y);
                        newChest.components.sprite=new Sprite(new Vector2(5,5),new Vector2(40,40),"chest.png");
                        MapManager.SetTile(TileTypes.chest, MapManager.currentMap, gridX - 1 - i, gridY);
                        MapManager.SetObject(newChest, MapManager.currentMap, gridX - 1 - i, gridY);
                    }
                    else {
                        MapManager.SetTile(TileTypes.empty, MapManager.currentMap, gridX - 1 - i, gridY);
                        MapManager.SetObject(null, MapManager.currentMap, gridX - 1 - i, gridY);
                    }
                    left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*(i+1),thisPosition.y),new Vector2(50,50),"explosionEndLeft.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX-1-i,gridY)==TileTypes.chest){
                    GameObject powerUp=new GameObject("powerUp");
                    powerUp.position=new Vector2(thisPosition.x-50*(i+1),thisPosition.y);

                    int a =rand.nextInt(0,3);
                    if(a==0)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerSpeed.png");
                    if(a==1)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerBomb.png");
                    if(a==2)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerExplosion.png");
                    powerUp.components.physicalBody=new PowerUpColider(a+1);
                    MapManager.SetTile(TileTypes.empty,MapManager.currentMap,gridX-1-i,gridY);
                    GameManager.Destroy(MapManager.GetObject(MapManager.currentMap,gridX-1-i,gridY));
                    MapManager.SetObject(null,MapManager.currentMap,gridX-1-i,gridY);
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX-1-i,gridY)==TileTypes.wallIn){
                    if(i==0)break;
                    left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*i,thisPosition.y),new Vector2(50,50),"explosionEndLeft.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX-1-i,gridY)==TileTypes.bomb){
                    ((BombScript) MapManager.GetObject(MapManager.currentMap, gridX+1+i,gridY).components.script).timeToExplode=1;
                }
                if(i+1==range){
                    left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*(i+1),thisPosition.y),new Vector2(50,50),"explosionEndLeft.png");
                    break;
                }
                left.components.sprite = new Sprite(new Vector2(thisPosition.x-50*(i+1),thisPosition.y),new Vector2(50,50),"explosionHorizontal.png");
            }
            for(int i=0;i<range;i++) {
                GameObject down = new GameObject("ExplosionU");
                down.components.script=new BombScript(0,1);
                if(MapManager.GetTile(MapManager.currentMap,gridX,gridY-1-i)==TileTypes.wallDe){
                    GameObject wall=MapManager.GetObject(MapManager.currentMap,gridX,gridY-1-i);
                    GameManager.Destroy(wall);
                    if(rand.nextInt(0,5)==0){
                        GameObject newChest=new GameObject("Chest");
                        newChest.position=new Vector2(thisPosition.x,thisPosition.y-50*(i+1));
                        newChest.components.sprite=new Sprite(new Vector2(5,5),new Vector2(40,40),"chest.png");
                        MapManager.SetTile(TileTypes.chest, MapManager.currentMap, gridX, gridY-1-i);
                        MapManager.SetObject(newChest, MapManager.currentMap, gridX, gridY-1-i);
                    }
                    else {
                        MapManager.SetTile(TileTypes.empty, MapManager.currentMap, gridX, gridY-1-i);
                        MapManager.SetObject(null, MapManager.currentMap, gridX, gridY-1-i);
                    }
                    down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*(i+1)),new Vector2(50,50),"explosionEndUp.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY-1-i)==TileTypes.chest){
                    GameObject powerUp=new GameObject("powerUp");
                    powerUp.position=new Vector2(thisPosition.x,thisPosition.y-50*(i+1));

                    int a =rand.nextInt(0,3);
                    if(a==0)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerSpeed.png");
                    if(a==1)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerBomb.png");
                    if(a==2)powerUp.components.sprite=new Sprite(new Vector2(10,10),new Vector2(30,30),"PowerExplosion.png");
                    powerUp.components.physicalBody=new PowerUpColider(a+1);
                    MapManager.SetTile(TileTypes.empty,MapManager.currentMap,gridX, gridY-1-i);
                    GameManager.Destroy(MapManager.GetObject(MapManager.currentMap,gridX, gridY-1-i));
                    MapManager.SetObject(null,MapManager.currentMap,gridX, gridY-1-i);
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY-1-i)==TileTypes.wallIn){
                    if(i==0)break;
                    down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*i),new Vector2(50,50),"explosionEndUp.png");
                    break;
                }
                else if(MapManager.GetTile(MapManager.currentMap,gridX, gridY-1-i)==TileTypes.bomb){
                    ((BombScript) MapManager.GetObject(MapManager.currentMap, gridX+1+i,gridY).components.script).timeToExplode=1;
                }
                if(i+1==range){
                    down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*(i+1)),new Vector2(50,50),"explosionEndUp.png");
                    break;
                }
                down.components.sprite = new Sprite(new Vector2(thisPosition.x,thisPosition.y-50*(i+1)),new Vector2(50,50),"explosionVertical.png");
            }

        }
        GameManager.Destroy(thisGameObject);
    }
}
