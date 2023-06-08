package AllirEngine;


public class GameTimer {
    static long start;
    public static double fps=60;

    static int frames=0;
    static int maxFrames=10;
    static boolean updated=false;
    static double actualFps;
    final static int averageFpsAbout=5;

    static int counter=0;
    static double maxCounter=15;



    public static void MeasureFps(){
        if(frames==0)start=System.nanoTime();
        if(frames==maxFrames){
            frames=0;
            actualFps=1000000000f/((double)(System.nanoTime()-start)/(double)maxFrames);
            //ShowFps();
            fps=(fps*averageFpsAbout-fps+actualFps)/averageFpsAbout;
            updated=true;
            maxFrames=(int)fps/5;
            if(maxFrames<=0)maxFrames=1;
            return;
        }
        frames++;
    }
    public static void ShowFps(){
        System.out.println("fps:"+fps);
        System.out.println(maxCounter);
    }

    public static double GetFps(){
        return actualFps;
    }

    public static double GetFrameSkip(){
        return maxCounter;
    }

    public static boolean WaitForFps(int fpsTarget){
        counter++;
        if(updated) {
            if((double)fpsTarget/fps>1.05f||(double)fpsTarget/fps<0.95f) {
                double diffrence = fps/(double)fpsTarget;
                if(diffrence>1.2&&diffrence<1.5)diffrence=1.2;
                if(diffrence<0.8&&diffrence>0.6)diffrence=0.8;
                maxCounter*=diffrence;
            }
            updated=false;
        }
        if(counter>=maxCounter){
            counter=0;
            return true;
        }
        return false;
    }
}
