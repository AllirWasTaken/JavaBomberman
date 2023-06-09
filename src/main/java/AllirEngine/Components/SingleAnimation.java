package AllirEngine.Components;



import javafx.scene.image.Image;

import java.util.List;

public class SingleAnimation {
    public String animationName;
    public int framesDelay;
    public int currentFrame=0;
    public int delayLeft=0;
    public List<Image> frames;

    public SingleAnimation(int framesDelay,String animationName,String ... framesNames){
        this.framesDelay=framesDelay;
        this.animationName=animationName;
        for(int i=0;i<framesNames.length;i++){
            frames.add(new javafx.scene.image.Image(getClass().getResourceAsStream("/img/"+framesNames[i])));
        }
    }
}
