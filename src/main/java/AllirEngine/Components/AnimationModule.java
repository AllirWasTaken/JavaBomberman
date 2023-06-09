package AllirEngine.Components;

import java.util.ArrayList;
import java.util.List;

public class AnimationModule {
    public List<SingleAnimation> animationList;
    public boolean isPlaying=false;
    public boolean stopIt=false;
    public int currentlyPlaying;
    public AnimationModule(){
        animationList=new ArrayList<>();
    }
    public void AddAnimation(int framesDelay,String animationName,String ... frames){
        if(frames.length==0||framesDelay<0)return;
        animationList.add(new SingleAnimation(framesDelay,animationName,frames));
    }
    public void Play(String AnimationName){
        if(isPlaying)Stop();
        currentlyPlaying=FindAnimation(AnimationName);
        if(currentlyPlaying==-1)return;
        isPlaying=true;
        animationList.get(currentlyPlaying).delayLeft=animationList.get(currentlyPlaying).framesDelay;
        animationList.get(currentlyPlaying).currentFrame=0;
    }
    public void Stop(){
        if(!isPlaying)return;
        stopIt=true;
    }
    public int FindAnimation(String name){
        for(int i=0;i<animationList.size();i++){
            if(animationList.get(i).animationName.equals(name))return i;
        }
        return -1;
    }
}
