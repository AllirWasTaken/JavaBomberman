package AllirEngine;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    static List<Scene> scenes;
    static GameManager manager;
    static int currentScene=-1;
    static boolean isSceneLoaded=false;
    static int loadAction=0;
    static boolean run;

    static JavaFxModule jfm;
    String [] MainArgs;




    public static void AddScene(Scene scene){
        if(currentScene==-1)currentScene=0;
        scenes.add(scene);
    }
    public static Scene GetCurrentScene(){
        return GetScene(currentScene);
    }

    public static void Initialize(String[] args){
        new GameManager();
        manager.MainArgs=args;
    }
    public GameManager(){
        if(manager==null) {
            scenes = new ArrayList<>();
            manager = this;
        }
    }

    public static Scene GetScene(int id){
        if(id<0||scenes.size()<=id)return null;
        return scenes.get(id);
    }
    public static Scene GetScene(String nameOfScene){
        for(int i=0;i<scenes.size();i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return GetScene(i);
        }
        return null;
    }

    public static int GetSceneNumber(String nameOfScene){
        for(int i=0;i<scenes.size();i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return i;
        }
        return -1;
    }
    void ExecuteScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++) {
            if (GetCurrentScene().GetGameObject(i).components.script != null) {
                if (!GetCurrentScene().GetGameObject(i).components.script.started) {
                    GetCurrentScene().GetGameObject(i).components.script.Start();
                    GetCurrentScene().GetGameObject(i).components.script.Started();
                }
                GetCurrentScene().gameObjects.get(i).components.script.Update();
            }
        }
    }

    public static void UnloadScene(){
        if(isSceneLoaded){
            loadAction=-2;
        }
    }
    public static void LoadScene(){
        if(!isSceneLoaded){
            loadAction=-1;
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
        jfm=new JavaFxModule();
        jfm.Launch(manager.MainArgs);
    }

    public void RunGame(GraphicsContext gc){
        run=true;
        while(run){

            if(loadAction!=0){
                if(loadAction==-1){

                    loadAction=0;
                }
                if(loadAction==-2){

                    loadAction=0;
                }
                if(loadAction>=1){


                    loadAction=0;
                }
            }

            manager.ExecuteScripts();
        }
    }
    public static void LaunchGame(){
        InitializeGame();
    }
}
