package AllirEngine;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class Input {
    static List<KeyCode> list;
    public static void RegisterKey(KeyCode key){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key)return;
        }
        list.add(key);
    }

    public static void Init(){
        list=new ArrayList<>();
    }

    public static boolean GetKeyDown(KeyCode key){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key)return true;
        }
        return false;
    }

    public static void RemoveKeyFromRegister(KeyCode key){
        list.remove(key);
    }

    public static void ClearKeyRegister(){
        if(list!=null)list.clear();
    }
}
