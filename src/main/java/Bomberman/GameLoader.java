package Bomberman;

import AllirEngine.*;
import AllirEngine.Components.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class GameLoader {
    GameScene gameScene;
    public void LoadRandomMap(){
        gameScene=new GameScene("Map1");

        for(int y=1;y<15;y++){
            for(int x=1;x<31;x++){
                GameObject object= new GameObject("GridTile",gameScene);
                object.position=new Vector2(x*50,y*50+100);
                object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"podłoga.png");
            }
        }
        for(int y=0;y<16;y++){
            for(int x=0;x<32;x++){
                if((y==0||y==15)||(x==0||x==31)) {
                    GameObject object = new GameObject("MapWall",gameScene);
                    object.position = new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "wallIn.png");
                }
            }
        }
        Random r=new Random();
        for(int y=1;y<15;y++){
            for(int x=1;x<31;x++) {
                if (r.nextInt(0, 4) == 0) {
                    GameObject object = new GameObject("Wall",gameScene);
                    object.position = new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "wallDe.png");
                    object.components.physicalBody=new EmptyColider(new Vector2(),new Vector2(50,50));
                }
            }
        }

    }

    void LoadMap(int number,String fileName){
        gameScene=new GameScene("Map"+number);
        Scanner mapScanner;
        try {
            mapScanner = new Scanner(getClass().getResourceAsStream("/maps/"+fileName));
        }
        catch (Exception e){
            return;
        }
        for(int y=0;y<16;y++){
            String line = mapScanner.nextLine();
            String[] lineNumbers=line.split(" ");
            for(int x=0;x<32;x++){
                GameObject object = new GameObject("emptyTile",gameScene);
                object.position=new Vector2(x * 50, y * 50 + 100);
                object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"podłoga.png");
                TileTypes tile=TileTypes.empty;
                int nr=Integer.parseInt(lineNumbers[x]);
                if(nr==0){
                    tile=TileTypes.empty;
                }
                else if(nr==1){
                    tile=TileTypes.wallIn;
                    object=new GameObject("wallIn",gameScene);
                    object.position=new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"wallIn.png");
                    object.components.physicalBody=new EmptyColider(new Vector2(),new Vector2(50,50));
                }
                else if(nr==2){
                    tile=TileTypes.wallDe;
                    object=new GameObject("wallDe",gameScene);
                    object.position=new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"wallDe.png");
                    object.components.physicalBody=new EmptyColider(new Vector2(),new Vector2(50,50));
                    MapManager.SetObject(object,number,x,y);
                }
                else if(nr==3){
                    tile=TileTypes.chest;
                    object=new GameObject("chest",gameScene);
                    object.position=new Vector2(x * 50, y * 50 + 100);
                    object.components.sprite=new Sprite(new Vector2(5,5),new Vector2(40,40),"chest.png");
                    MapManager.SetObject(object,number,x,y);
                }


                MapManager.SetTile(tile,number,x,y);
            }
        }
    }

    void LoadFPSDisplay(){
        GameObject object = new GameObject("FPSCounter",gameScene);
        object.components.script=new FPSCounter();
        object.components.textSprite=new TextSprite(new Vector2(0,20),"FPS: ",20);
    }

    void LoadUI(){
        GameObject panel = new GameObject("UIPanel",gameScene);
        panel.components.sprite=new Sprite(new Vector2(),new Vector2(1600,100),Color.GRAY);
    }
    void LoadCharacters(){
        GameObject object = new GameObject("Character",gameScene);
        object.components.sprite=new Sprite(new Vector2(),new Vector2(50,50),"postać1Right1.png");
        object.position=new Vector2(500,500);
        object.components.script=new PlayerControl();
        ((PlayerControl) object.components.script).player=2;
        object.components.physicalBody=new PlayerBody(new Vector2(10,10),new Vector2(30,30));

        object.components.animationModule=new AnimationModule();
        object.components.animationModule.AddAnimation(7,"GoRight","postać1Right1.png","postać1Right2.png");
        object.components.animationModule.AddAnimation(7,"GoLeft","postać1Left1.png","postać1Left2.png");
        object.components.animationModule.AddAnimation(7,"GoUp","postać1Up1.png","postać1Up2.png");
        object.components.animationModule.AddAnimation(7,"GoDown","postać1Down1.png","postać1Down2.png");


    }
}
