package AllirEngine;

import AllirEngine.Components.*;


public class Component {
    public Script script;
    public Sprite sprite;
    public Sound sound;
    public Hover hover;
    public Click click;
    public Text text;
    public PhysicalBody physicalBody;

    public Component(){
        script=null;
        sprite=null;
        sound=null;
        hover=null;
        click=null;
        text=null;
        physicalBody=null;
    }

}
