package Bomberman;

import AllirEngine.Components.Script;
import AllirEngine.GameObject;
import AllirEngine.Vector2;

public class VentScript extends Script{
    double Distance(GameObject vent, GameObject postac){
        float x1,y1,x2,y2;
        x1=vent.position.x;
        y1=vent.position.y;
        x2=postac.position.x;
        y2=postac.position.y;
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

    void OpenVent (){
        if(!isopen && cooldown<1){
            thisGameObject.components.sprite.ReplaceSprite("OpenVent.png");
            isopen=true;
        }
    }

    void Jump(GameObject p){
        if(cooldown<=0){
            p.position=new Vector2(diffvent.position.x,diffvent.position.y);
            cooldown=300;
            ((VentScript) diffvent.components.script).cooldown=300;
        }
    }
    GameObject p1,p2,p3,diffvent;
    double maxodlegosc=70;
    double enter=25;
    boolean isopen;
    int nrvent;
    int cooldown=0;

    VentScript(int numer){
        nrvent = numer;
    }
    @Override
    public void Update() {
    cooldown--;
        if(Distance(thisGameObject,p1)<maxodlegosc){
            if(Distance(thisGameObject,p1)<enter){
                Jump(p1);
            }
            OpenVent();
        }
        else if (Distance(thisGameObject,p2)<maxodlegosc){
            if(Distance(thisGameObject,p2)<enter){
                Jump(p2);
            }
            OpenVent();
        }
        else if(Distance(thisGameObject,p3)<maxodlegosc){
            if(Distance(thisGameObject,p3)<enter){
                Jump(p3);
            }
            OpenVent();
        }
        else{
            if(isopen){
                thisGameObject.components.sprite.ReplaceSprite("ClosedVent.png");
                isopen = false;
            }
        }
    }

    @Override
    public void Start() {
        p1 = thisGameScene.GetGameObject("Character1");
        p2 = thisGameScene.GetGameObject("Character2");
        p3 = thisGameScene.GetGameObject("Character3");
        if(nrvent==1){
            diffvent = thisGameScene.GetGameObject("Went 2");
        }
        else if(nrvent==2){
            diffvent = thisGameScene.GetGameObject("Went 1");
        }
        if(nrvent==3){
            diffvent = thisGameScene.GetGameObject("Went 4");
        }
        else if(nrvent==4){
            diffvent = thisGameScene.GetGameObject("Went 3");
        }
    }
}
