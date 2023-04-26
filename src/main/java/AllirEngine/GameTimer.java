package AllirEngine;


public class GameTimer {
    static long start;
    static double fps=60;

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
            ShowFps();
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

    public static boolean WaitForFps(int fpsTarget){
        counter++;
        if(updated) {
            if((double)fpsTarget/fps>1.1f||(double)fpsTarget/fps<0.9f) {
                maxCounter *= fps/(double)fpsTarget;
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
