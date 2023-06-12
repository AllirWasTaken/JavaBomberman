package AllirEngine;

import AllirEngine.Components.*;


public class Component {
    public Script script;
    public Sprite sprite;
    public Sound sound;
    public boolean hover;
    public boolean click;
    public TextSprite textSprite;
    public PhysicalBody physicalBody;
    public AnimationModule animationModule;

    public Component(){
        script=null;
        sprite=null;
        sound=null;
        hover=false;
        click=false;
        textSprite =null;
        physicalBody=null;
        animationModule=null;
    }

}
