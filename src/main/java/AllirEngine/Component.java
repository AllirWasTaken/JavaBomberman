package AllirEngine;

import AllirEngine.Components.*;


public class Component {
    public Script script;
    public Sprite sprite;
    public Sound sound;
    public boolean hover;
    public boolean click;
    public Text text;
    public PhysicalBody physicalBody;

    public Component(){
        script=null;
        sprite=null;
        sound=null;
        hover=false;
        click=false;
        text=null;
        physicalBody=null;
    }

}
