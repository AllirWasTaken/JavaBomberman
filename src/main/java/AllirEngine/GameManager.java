package AllirEngine;

import AllirEngine.Components.Sprite;
import AllirEngine.Components.SpriteType;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    static List<GameScene> gameScenes;
    static GameManager manager;
    static int currentScene=-1;
    static boolean isSceneLoaded=false;
    static int loadAction=0;

    boolean run;

    static JavaFxModule jfm;
    String [] MainArgs;
    public int screenWidth;
    public int screenHeight;
    public static int fpsLimit=60;





    public static void AddScene(GameScene gameScene){
        if(currentScene==-1)currentScene=0;
        gameScenes.add(gameScene);
    }
    public static GameScene GetCurrentScene(){
        return GetScene(currentScene);
    }

    public static void Initialize(String[] args,int screenWidth,int screenHeight){
        new GameManager();
        manager.MainArgs=args;
        manager.screenHeight=screenHeight;
        manager.screenWidth=screenWidth;
    }
    public GameManager(){
        if(manager==null) {
            gameScenes = new ArrayList<>();
            Input.Init();
            manager = this;
        }
    }

    public static void ShutDownGame(){
        manager.run=false;
    }

    public static GameScene GetScene(int id){
        if(id<0|| gameScenes.size()<=id)return null;
        return gameScenes.get(id);
    }
    public static GameScene GetScene(String nameOfScene){
        for(int i = 0; i< gameScenes.size(); i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return GetScene(i);
        }
        return null;
    }

    public static int GetSceneNumber(String nameOfScene){
        for(int i = 0; i< gameScenes.size(); i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return i;
        }
        return -1;
    }
    void ExecuteScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++) {
            if (GetCurrentScene().GetGameObject(i).components.script != null) {
                if (!GetCurrentScene().GetGameObject(i).components.script.started) {
                    GetCurrentScene().GetGameObject(i).components.script.thisGameObject=GetCurrentScene().GetGameObject(i);
                    GetCurrentScene().GetGameObject(i).components.script.thisGameScene=GetCurrentScene();
                    GetCurrentScene().GetGameObject(i).components.script.Start();
                    GetCurrentScene().GetGameObject(i).components.script.started=true;
                }
                GetCurrentScene().gameObjects.get(i).components.script.Update();
            }
        }
    }

    void ResetScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.script!=null){
                GetCurrentScene().GetGameObject(i).components.script.started=false;
            }
        }
    }

    void DrawSprites(GraphicsContext gc){
        gc.setFill(GetCurrentScene().backgroundColor);
        gc.fillRect(0,0,screenWidth,screenHeight);
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.sprite!=null){
                Sprite currentSprite=GetCurrentScene().GetGameObject(i).components.sprite;
                if(currentSprite.type== SpriteType.SIMPLE_RECTANGLE){
                    gc.setFill(currentSprite.color);
                    gc.fillRect(GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x
                            ,GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y,
                            currentSprite.size.x,currentSprite.size.y);
                }
                else if(currentSprite.type== SpriteType.SIMPLE_CIRCLE){
                    gc.setFill(currentSprite.color);
                    gc.fillOval(GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x
                            ,GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y,
                            currentSprite.size.x,currentSprite.size.x);
                }
                else if(currentSprite.type== SpriteType.IMAGE){
                    ImageView temp= new ImageView();
                    temp.setImage(currentSprite.image);
                    temp.setX(GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x);
                    temp.setY(GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y);
                    temp.setFitWidth(currentSprite.size.x);
                    temp.setFitHeight(currentSprite.size.y);
                }
            }
        }
    }
    public static void UnloadScene(){
        if(isSceneLoaded){
            loadAction=-1;
        }
    }

    public boolean DoWeColide(GameObject object1, GameObject object2){
     if(object1.position.x+object1.components.physicalBody.relativePosition.x+object1.components.physicalBody.size.x
             >=object2.position.x+object2.components.physicalBody.relativePosition.x
             &&object1.position.y+object1.components.physicalBody.relativePosition.y+object1.components.physicalBody.size.y
             >=object2.position.y+object2.components.physicalBody.relativePosition.y
             &&object1.position.x+object1.components.physicalBody.relativePosition.x
             <=object2.position.x+object2.components.physicalBody.size.x+object2.components.physicalBody.relativePosition.x
             &&object1.position.y+object1.components.physicalBody.relativePosition.y
             <=object2.position.y+object2.components.physicalBody.relativePosition.y+object2.components.physicalBody.size.y)
         return true;
     else return false;
    }
    public void Colisions(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.physicalBody!=null){
                    for(int j=0;j<GetCurrentScene().gameObjects.size();j++) {
                        if(GetCurrentScene().GetGameObject(j)!=null){
                            if(i!=j) {
                                GameObject object1 = GetCurrentScene().GetGameObject(i);
                                GameObject object2 = GetCurrentScene().GetGameObject(j);
                                object1.components.physicalBody.thisGameObject=object1;
                                object1.components.physicalBody.thisGameScene=GetCurrentScene();
                                object2.components.physicalBody.thisGameObject=object2;
                                object2.components.physicalBody.thisGameScene=GetCurrentScene();
                                if (DoWeColide(object1, object2)) {
                                    object1.components.physicalBody.OnColision(object2);
                                    object2.components.physicalBody.OnColision(object1);
                                }
                            }
                    }
                }
            }
        }
    }
    public static void SwitchScene(int number){
        loadAction = number;
    }
    public static void SwitchScene(String name){
        loadAction=GetSceneNumber(name);
        if(loadAction==-1)loadAction=0;
    }

    static void InitializeGame(){
        manager.run=true;
        jfm=new JavaFxModule();
        jfm.Launch(manager.MainArgs);
    }

    public void RunGame(GraphicsContext gc){
        if(GameTimer.WaitForFps(fpsLimit)) {
            if (manager.run) {
                GameTimer.MeasureFps();
                if (loadAction != 0) {
                    ResetScripts();
                    if (loadAction == -1) {
                        currentScene = -1;
                        isSceneLoaded = false;
                        loadAction = 0;
                    }
                    if (loadAction >= 1) {
                        currentScene = loadAction;
                        isSceneLoaded = true;
                        loadAction = 0;
                    }
                }

                if (currentScene != -1) {
                    manager.Colisions();
                    manager.ExecuteScripts();
                    manager.DrawSprites(gc);
                }
            } else {
                Platform.exit();
            }
        }
    }
    public static void LaunchGame(){
        InitializeGame();
    }
}
