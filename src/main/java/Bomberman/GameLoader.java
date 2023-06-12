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
        LoadUI(number);
        LoadCharacters(number);
    }

    void ReloadMap(int number,String fileName){
        gameScene=GameManager.GetScene("Map"+number);
        gameScene.gameObjects.clear();
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
        LoadUI(number);
        LoadCharacters(number);

    }

    void LoadFPSDisplay(){
        gameScene=GameManager.GetScene("Map1");
        GameObject object = new GameObject("FPSCounter",gameScene);
        object.components.script=new FPSCounter();
        object.components.textSprite=new TextSprite(new Vector2(0,20),"FPS: ",20);
    }

    void LoadUI(int number){
            GameScene scene = GameManager.GetScene("Map" + (number));
            GameObject panel = new GameObject("UIPanel", scene);
            panel.components.sprite = new Sprite(new Vector2(), new Vector2(1600, 100), Color.GRAY);

            GameObject uiManager=new GameObject("UIManager",scene);
            uiManager.components.script=new UIScript();

            GameObject timer = new GameObject("timer",scene);
            timer.position=new Vector2(1000,30);
            timer.components.textSprite=new TextSprite(new Vector2(0,20),"TIME\n0:00",20);

            GameObject backToMenu=new GameObject("BackToMenu",scene);
            backToMenu.position=new Vector2(1500,0);
            backToMenu.components.sprite=new Sprite(new Vector2(5,5),new Vector2(90,90),"ExitToMenu.png");
            backToMenu.components.script=new UIButtonsScript();
            backToMenu.components.click=true;

        GameObject music=new GameObject("MusicButton",scene);
        music.position=new Vector2(1300,0);
        music.components.sprite=new Sprite(new Vector2(5,5),new Vector2(90,90),"musicOn.png");
        music.components.script=new UIButtonsScript();
        music.components.click=true;

        GameObject sound=new GameObject("SoundButton",scene);
        sound.position=new Vector2(1200,0);
        sound.components.sprite=new Sprite(new Vector2(5,5),new Vector2(90,90),"soundOn.png");
        sound.components.script=new UIButtonsScript();
        sound.components.click=true;


        for(int i=0;i<3;i++) {
            Vector2 pos=new Vector2();
            if(i==0)pos=new Vector2(5, 5);
            if(i==1)pos=new Vector2(330, 5);
            if(i==2)pos=new Vector2(655, 5);

            GameObject canvas = new GameObject("canvas", scene);
            canvas.position = new Vector2(pos.x, pos.y);
            canvas.components.sprite = new Sprite(new Vector2(), new Vector2(320, 90), Color.DARKGRAY);

            GameObject playerIcon = new GameObject("playerIcon", scene);
            playerIcon.position=new Vector2(pos.x+5,pos.y+5);
            playerIcon.components.sprite=new Sprite(new Vector2(),new Vector2(80,80),"player"+(i+1)+"Icon.png");

            GameObject playerName = new GameObject("playerName", scene);
            playerName.position=new Vector2(pos.x+90,pos.y+5);
            playerName.components.textSprite=new TextSprite(new Vector2(0,20),"PLAYER"+(i+1),20);

            GameObject bombText = new GameObject("bombText"+(i+1), scene);
            bombText.position=new Vector2(pos.x+120,pos.y+25);
            bombText.components.textSprite=new TextSprite(new Vector2(0,20),"BOMBS:1/1",20);

            GameObject strength = new GameObject("strengthText"+(i+1), scene);
            strength.position=new Vector2(pos.x+120,pos.y+45);
            strength.components.textSprite=new TextSprite(new Vector2(0,20),"STRENGTH:1",20);

            GameObject speed = new GameObject("speedText"+(i+1), scene);
            speed.position=new Vector2(pos.x+120,pos.y+65);
            speed.components.textSprite=new TextSprite(new Vector2(0,20),"SPEED:3",20);

            GameObject strIcon = new GameObject("strengthIcon", scene);
            strIcon.position=new Vector2(pos.x+100,pos.y+45);
            strIcon.components.sprite = new Sprite(new Vector2(-5,2),new Vector2(20,20),"PowerExplosion.png");

            strIcon = new GameObject("speedIcon", scene);
            strIcon.position=new Vector2(pos.x+100,pos.y+65);
            strIcon.components.sprite = new Sprite(new Vector2(-5,2),new Vector2(20,20),"PowerSpeed.png");

            strIcon = new GameObject("bombIcon", scene);
            strIcon.position=new Vector2(pos.x+100,pos.y+25);
            strIcon.components.sprite = new Sprite(new Vector2(-5,2),new Vector2(20,20),"PowerBomb.png");

        }


    }
    void LoadCharacters(int number){


            GameScene scene = GameManager.GetScene("Map"+(number));
            number--;
            for(int j=1;j<4;j++) {
                GameObject object = new GameObject("Character"+j, scene);
                object.components.sprite = new Sprite(new Vector2(), new Vector2(50, 50), "postać"+j+"Right1.png");


                object.components.script = new PlayerControl();
                ((PlayerControl) object.components.script).player = j;
                object.components.physicalBody = new PlayerBody(new Vector2(10, 10), new Vector2(30, 30));

                object.components.animationModule = new AnimationModule();
                object.components.animationModule.AddAnimation(10, "GoRight", "postać"+j+"Right1.png", "postać"+j+"Right2.png");
                object.components.animationModule.AddAnimation(10, "GoLeft", "postać"+j+"Left1.png", "postać"+j+"Left2.png");
                object.components.animationModule.AddAnimation(10, "GoUp", "postać"+j+"Up1.png", "postać"+j+"Up2.png");
                object.components.animationModule.AddAnimation(10, "GoDown", "postać"+j+"Down1.png", "postać"+j+"Down2.png");

                if(number==0){
                    if(j==1)object.position = new Vector2(50, 150);
                    if(j==2)object.position = new Vector2(1500, 150);
                    if(j==3)object.position = new Vector2(50, 800);
                }
                else if(number==1){
                    if(j==1)object.position = new Vector2(50, 150);
                    if(j==2)object.position = new Vector2(1500, 150);
                    if(j==3)object.position = new Vector2(50, 800);
                }
                else if(number==2){
                    if(j==1)object.position = new Vector2(50, 150);
                    if(j==2)object.position = new Vector2(1500, 150);
                    if(j==3)object.position = new Vector2(50, 800);
                }
                else if(number==3){
                    if(j==1)object.position = new Vector2(50, 150);
                    if(j==2)object.position = new Vector2(1500, 150);
                    if(j==3)object.position = new Vector2(50, 800);
                }
            }




    }
}
