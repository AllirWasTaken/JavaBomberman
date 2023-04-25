package AllirEngine;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    static List<Scene> scenes;
    static GameManager manager;
    static int currentScene=0;
    static boolean run;


    public static void AddScene(Scene scene){
        scenes.add(scene);
    }
    public static Scene GetCurrentScene(){
        return scenes.get(currentScene);
    }

    public GameManager(){
        scenes=new ArrayList<>();
        manager=this;
    }

    void ExecuteScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(!GetCurrentScene().gameObjects.get(i).components.script.started){
                GetCurrentScene().gameObjects.get(i).components.script.Start();
                GetCurrentScene().gameObjects.get(i).components.script.Started();
            }
            GetCurrentScene().gameObjects.get(i).components.script.Update();
        }
    }

    public static void LaunchGame(){
        run=true;
        while(run){
            manager.ExecuteScripts();
        }
    }
}
