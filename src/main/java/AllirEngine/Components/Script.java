package AllirEngine.Components;

public abstract class Script {
     public abstract void Update();
     public abstract void Start();
     public boolean started=false;
     public void Started(){
          started=true;
     }
}
