package AllirEngine;

import AllirEngine.Components.AnimationModule;
import AllirEngine.Components.SingleAnimation;
import AllirEngine.Components.Sprite;
import AllirEngine.Components.SpriteType;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    static List<GameScene> gameScenes;
    static GameManager manager;
    static int currentScene=-1;
    static boolean isSceneLoaded=false;
    static int loadAction=0;


    boolean run;

    static JavaFxModule jfm;
    Group group;
    public Canvas canvas;
    String [] MainArgs;
    public int gameWidth;
    public int gameHeight;
    public int screenWidth,screenHeight;

    public static int fpsLimit=60;

    public float xConvSTG, yConvSTG;





    public static void AddScene(GameScene gameScene){
        if(currentScene==-1)currentScene=0;
        gameScenes.add(gameScene);
    }
    public static GameScene GetCurrentScene(){
        return GetScene(currentScene);
    }

    public static void Initialize(String[] args,int screenWidth,int screenHeight, int gameWidth, int gameHeight){
        new GameManager();
        manager.MainArgs=args;
        manager.gameHeight = gameHeight;
        manager.gameWidth = gameWidth;
        manager.screenHeight=screenHeight;
        manager.screenWidth=screenWidth;
        manager.xConvSTG =(float)gameWidth/(float)screenWidth;
        manager.yConvSTG =(float)gameHeight/(float)screenHeight;
    }
    public GameManager(){
        if(manager==null) {
            gameScenes = new ArrayList<>();
            Input.Init();
            manager = this;
        }
    }



    public static void ShutDownGame(){
        manager.run=false;
    }

    public static GameScene GetScene(int id){
        if(id<0|| gameScenes.size()<=id)return null;
        return gameScenes.get(id);
    }
    public static GameScene GetScene(String nameOfScene){
        for(int i = 0; i< gameScenes.size(); i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return GetScene(i);
        }
        return null;
    }

    public static int GetSceneNumber(String nameOfScene){
        for(int i = 0; i< gameScenes.size(); i++){
            if(nameOfScene.equals(GetScene(i).nameOfScene))return i;
        }
        return -1;
    }
    void ExecuteScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++) {
            if (GetCurrentScene().GetGameObject(i).components.script != null) {
                if (!GetCurrentScene().GetGameObject(i).components.script.started) {
                    GetCurrentScene().GetGameObject(i).components.script.thisGameObject=GetCurrentScene().GetGameObject(i);
                    GetCurrentScene().GetGameObject(i).components.script.thisGameScene=GetCurrentScene();
                    GetCurrentScene().GetGameObject(i).components.script.Start();
                    GetCurrentScene().GetGameObject(i).components.script.started=true;
                }
                GetCurrentScene().gameObjects.get(i).components.script.Update();
            }
        }
    }

    void ResetScripts(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.script!=null){
                GetCurrentScene().GetGameObject(i).components.script.started=false;
            }
        }
    }

    void DrawSprites(GraphicsContext gc){
        gc.setFill(GetCurrentScene().backgroundColor);
        gc.fillRect(0,0, gameWidth/ xConvSTG, gameHeight/ yConvSTG);
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.sprite!=null){
                Sprite currentSprite=GetCurrentScene().GetGameObject(i).components.sprite;
                if(currentSprite.type== SpriteType.SIMPLE_RECTANGLE){
                    gc.setFill(currentSprite.color);
                    gc.fillRect((GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x)/ xConvSTG
                            ,(GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y)/ yConvSTG,
                            currentSprite.size.x/ xConvSTG,currentSprite.size.y/ yConvSTG);
                }
                else if(currentSprite.type== SpriteType.SIMPLE_CIRCLE){
                    gc.setFill(currentSprite.color);
                    gc.fillOval((GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x)/ xConvSTG
                            ,(GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y)/ yConvSTG,
                            currentSprite.size.x/ xConvSTG,currentSprite.size.x/ xConvSTG);
                }
                else if(currentSprite.type== SpriteType.IMAGE){
                    if(!currentSprite.loaded){
                        currentSprite.imageView.setFitWidth(currentSprite.size.x/ xConvSTG);
                        currentSprite.imageView.setFitHeight(currentSprite.size.y/ yConvSTG);
                        group.getChildren().add(currentSprite.imageView);
                        currentSprite.loaded=true;
                    }
                    ImageView temp = currentSprite.imageView;
                    temp.setX((GetCurrentScene().GetGameObject(i).position.x+currentSprite.relativePosition.x)/ xConvSTG);
                    temp.setY((GetCurrentScene().GetGameObject(i).position.y+currentSprite.relativePosition.y)/ yConvSTG);
                }
            }
        }
    }
    public static void UnloadScene(){
        if(isSceneLoaded){
            loadAction=-1;
        }
    }

    public boolean DoWeColide(GameObject object1, GameObject object2){
     if(object1.position.x+object1.components.physicalBody.relativePosition.x+object1.components.physicalBody.size.x
             >=object2.position.x+object2.components.physicalBody.relativePosition.x
             &&object1.position.y+object1.components.physicalBody.relativePosition.y+object1.components.physicalBody.size.y
             >=object2.position.y+object2.components.physicalBody.relativePosition.y
             &&object1.position.x+object1.components.physicalBody.relativePosition.x
             <=object2.position.x+object2.components.physicalBody.size.x+object2.components.physicalBody.relativePosition.x
             &&object1.position.y+object1.components.physicalBody.relativePosition.y
             <=object2.position.y+object2.components.physicalBody.relativePosition.y+object2.components.physicalBody.size.y)
         return true;
     else return false;
    }
    public void Colisions(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.physicalBody!=null){
                    for(int j=0;j<GetCurrentScene().gameObjects.size();j++) {
                        if(GetCurrentScene().GetGameObject(j).components.physicalBody!=null){
                            if(GetCurrentScene().GetGameObject(j).components.physicalBody.DetectColisions) {
                                if (i != j) {
                                    GameObject object1 = GetCurrentScene().GetGameObject(i);
                                    GameObject object2 = GetCurrentScene().GetGameObject(j);
                                    object1.components.physicalBody.thisGameObject = object1;
                                    object1.components.physicalBody.thisGameScene = GetCurrentScene();
                                    object2.components.physicalBody.thisGameObject = object2;
                                    object2.components.physicalBody.thisGameScene = GetCurrentScene();
                                    if (DoWeColide(object1, object2)) {
                                        object1.components.physicalBody.OnColision(object2);
                                        object2.components.physicalBody.OnColision(object1);
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
    public void Repulsions(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            if(GetCurrentScene().GetGameObject(i).components.physicalBody!=null){
                for(int j=0;j<GetCurrentScene().gameObjects.size();j++) {
                    if(GetCurrentScene().GetGameObject(j).components.physicalBody!=null){
                        if(!GetCurrentScene().GetGameObject(j).components.physicalBody.PassTroughPhysicalBodies) {
                            if (i != j) {
                                GameObject object1 = GetCurrentScene().GetGameObject(i);
                                GameObject object2 = GetCurrentScene().GetGameObject(j);
                                object1.components.physicalBody.thisGameObject = object1;
                                object1.components.physicalBody.thisGameScene = GetCurrentScene();
                                object2.components.physicalBody.thisGameObject = object2;
                                object2.components.physicalBody.thisGameScene = GetCurrentScene();
                                if (DoWeColide(object1, object2)) {
                                    Repel(object1,object2);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            GameObject object =GetCurrentScene().GetGameObject(i);
            if(object.components.physicalBody!=null){
                if(!object.components.physicalBody.PassTroughPhysicalBodies){

                    if(object.components.physicalBody.RepulsionCorrection!=null) {
                        object.position.x -= object.components.physicalBody.RepulsionCorrection.x;
                        object.position.y -= object.components.physicalBody.RepulsionCorrection.y;
                        object.components.physicalBody.RepulsionCorrection=null;
                    }
                    object.components.physicalBody.HardRepulsion=false;
                    object.components.physicalBody.lastPosition= new Vector2(object.position.x,object.position.y);
                }
            }
        }
    }

    public void Repel(GameObject repeller, GameObject object){

        Vector2 TLDiff,BRDiff;
        TLDiff=new Vector2(
                (object.position.x+object.components.physicalBody.relativePosition.x+object.components.physicalBody.size.x)
                        -(repeller.position.x+repeller.components.physicalBody.relativePosition.x),
                (object.position.y+object.components.physicalBody.relativePosition.y+object.components.physicalBody.size.y)
                        -(repeller.position.y+repeller.components.physicalBody.relativePosition.y)
        );
        if(TLDiff.x>repeller.components.physicalBody.size.x||TLDiff.x==0)TLDiff.x=-1;
        if(TLDiff.y>repeller.components.physicalBody.size.y||TLDiff.y==0)TLDiff.y=-1;
        BRDiff=new Vector2(
                (repeller.position.x+repeller.components.physicalBody.relativePosition.x+repeller.components.physicalBody.size.x)
                        -(object.position.x+object.components.physicalBody.relativePosition.x),
                (repeller.position.y+repeller.components.physicalBody.relativePosition.y+repeller.components.physicalBody.size.y)
                -(object.position.y+object.components.physicalBody.relativePosition.y)
        );
        if(BRDiff.x>repeller.components.physicalBody.size.x||BRDiff.x==0)BRDiff.x=-1;
        if(BRDiff.y>repeller.components.physicalBody.size.y||BRDiff.y==0)BRDiff.y=-1;

        Vector2 repulsionValue=new Vector2(object.position.x-object.components.physicalBody.lastPosition.x,
                object.position.y-object.components.physicalBody.lastPosition.y);



        if(TLDiff.x>0&&TLDiff.y>0){
            //TL
            if(TLDiff.x>TLDiff.y)repulsionValue.x=0;
            else if(TLDiff.x<TLDiff.y)repulsionValue.y=0;
            else{
                if(repulsionValue.x<0)repulsionValue.x=0;
                if(repulsionValue.y<0)repulsionValue.y=0;
            }
            if(repulsionValue.x>TLDiff.x)repulsionValue.x=TLDiff.x;
            if(repulsionValue.y>TLDiff.y)repulsionValue.y=TLDiff.y;

        }
        else if(BRDiff.x>0&&BRDiff.y>0){
            //BR
            if(BRDiff.x>BRDiff.y)repulsionValue.x=0;
            else if(BRDiff.x<BRDiff.y)repulsionValue.y=0;
            else{
                if(repulsionValue.x>0)repulsionValue.x=0;
                if(repulsionValue.y>0)repulsionValue.y=0;
            }

            if(repulsionValue.x>BRDiff.x)repulsionValue.x=BRDiff.x;
            if(repulsionValue.y>BRDiff.y)repulsionValue.y=BRDiff.y;
        }
        else if(BRDiff.x>0&&TLDiff.y>0){
            //TR
            if(BRDiff.x>TLDiff.y)repulsionValue.x=0;
            else if(BRDiff.x<TLDiff.y)repulsionValue.y=0;
            else{
                if(repulsionValue.x>0)repulsionValue.x=0;
                if(repulsionValue.y<0)repulsionValue.y=0;
            }
            if(repulsionValue.x>BRDiff.x)repulsionValue.x=BRDiff.x;
            if(repulsionValue.y>TLDiff.y)repulsionValue.y=BRDiff.y;
        }
        else if(BRDiff.y>0&&TLDiff.x>0){
            //BL
            if(TLDiff.x>BRDiff.y)repulsionValue.x=0;
            else if(TLDiff.x<BRDiff.y)repulsionValue.y=0;
            else{
                if(repulsionValue.x<0)repulsionValue.x=0;
                if(repulsionValue.y>0)repulsionValue.y=0;
            }
            if(repulsionValue.x>TLDiff.x)repulsionValue.x=TLDiff.x;
            if(repulsionValue.y>BRDiff.y)repulsionValue.y=BRDiff.y;
        }
        else{
            repulsionValue.x=0;
            repulsionValue.y=0;
        }
        if(!object.components.physicalBody.HardRepulsion)object.components.physicalBody.RepulsionCorrection=new Vector2(repulsionValue.x, repulsionValue.y);
        else{
            if(Math.abs(repulsionValue.x)!=Math.abs(repulsionValue.y)) {
                if (object.components.physicalBody.RepulsionCorrection.x == 0)
                    object.components.physicalBody.RepulsionCorrection.x = repulsionValue.x;
                if (object.components.physicalBody.RepulsionCorrection.y == 0)
                    object.components.physicalBody.RepulsionCorrection.y = repulsionValue.y;
            }
        }
        if(Math.abs(repulsionValue.x)!=Math.abs(repulsionValue.y)){
            object.components.physicalBody.HardRepulsion=true;
        }



    }

    void AnimationExecutions(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            GameObject object=GetCurrentScene().gameObjects.get(i);
            if(object.components.animationModule!=null){
                AnimationModule animationMod=object.components.animationModule;
                Sprite spriteMod =object.components.sprite;
                if(animationMod.currentlyPlaying==3){
                    int a=5;
                }
                if(animationMod.stopIt){
                    animationMod.stopIt=false;
                    animationMod.isPlaying=false;
                    animationMod.animationList.get(animationMod.currentlyPlaying).currentFrame=0;
                    spriteMod.AnimationFrameReplace(animationMod.animationList.get(animationMod.currentlyPlaying).frames.get(0));
                }
                else if(animationMod.isPlaying){
                    SingleAnimation currentAnimation=animationMod.animationList.get(animationMod.currentlyPlaying);
                    if(currentAnimation.delayLeft==0){
                        currentAnimation.delayLeft=currentAnimation.framesDelay;
                        currentAnimation.currentFrame++;
                        if(currentAnimation.currentFrame==currentAnimation.frames.size())currentAnimation.currentFrame=0;
                        spriteMod.AnimationFrameReplace(currentAnimation.frames.get(currentAnimation.currentFrame));
                    }
                    else currentAnimation.delayLeft--;
                }
            }
        }
    }
    public static void SwitchScene(int number){
        loadAction = number;
    }
    public static void SwitchScene(String name){
        loadAction=GetSceneNumber(name);
        if(loadAction==-1)loadAction=-2;
    }

    static void InitializeGame(){
        manager.run=true;
        jfm=new JavaFxModule();

        jfm.Launch(manager.MainArgs);
    }

    void UnloadSpritesAndText(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++) {
            if(GetCurrentScene().GetGameObject(i).components.sprite!=null){
                if(GetCurrentScene().GetGameObject(i).components.sprite.type==SpriteType.IMAGE){
                    GetCurrentScene().GetGameObject(i).components.sprite.loaded=false;
                }
            }
            if(GetCurrentScene().GetGameObject(i).components.textSprite!=null){
                GetCurrentScene().GetGameObject(i).components.textSprite.loaded=false;
            }
        }
        group.getChildren().clear();
    }

    void MouseInputMethods(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            GameObject currentGameObject=GetCurrentScene().GetGameObject(i);
            if(currentGameObject.components.hover||currentGameObject.components.click){
                currentGameObject.hoveredOver=false;
                currentGameObject.clicked=false;
                if(Input.mousePosition.x>=currentGameObject.position.x+currentGameObject.components.sprite.relativePosition.x
                        && Input.mousePosition.y>=currentGameObject.position.y+currentGameObject.components.sprite.relativePosition.y
                        && Input.mousePosition.x<=currentGameObject.position.x+currentGameObject.components.sprite.relativePosition.x+currentGameObject.components.sprite.size.x
                        && Input.mousePosition.y<=currentGameObject.position.y+currentGameObject.components.sprite.relativePosition.y+currentGameObject.components.sprite.size.y){
                    if(currentGameObject.components.hover)currentGameObject.hoveredOver=true;
                    if(Input.isMouseClicked&&currentGameObject.components.click)currentGameObject.clicked=true;
                }
            }

        }
    }

    public static void RemoveSpriteFromScreen(ImageView imageView){
        manager.group.getChildren().remove(imageView);
    }

    public static void RemoveTextFromScreen(Text text){
        manager.group.getChildren().remove(text);
    }

    public void DrawText(){
        for(int i=0;i<GetCurrentScene().gameObjects.size();i++){
            GameObject currentGameObject=GetCurrentScene().GetGameObject(i);
            if(currentGameObject.components.textSprite!=null){
                if(!currentGameObject.components.textSprite.loaded){
                    currentGameObject.components.textSprite.loaded=true;
                    group.getChildren().add(currentGameObject.components.textSprite.text);
                }
                currentGameObject.components.textSprite.text.setX((currentGameObject.components.textSprite.relativePosition.x+currentGameObject.position.x)/ xConvSTG);
                currentGameObject.components.textSprite.text.setY((currentGameObject.components.textSprite.relativePosition.y+currentGameObject.position.y)/ yConvSTG);
            }
        }
    }



    public void RunGame(GraphicsContext gc){
        if(GameTimer.WaitForFps(fpsLimit)) {
            if (manager.run) {
                GameTimer.MeasureFps();
                if (loadAction != -2) {
                    ResetScripts();
                    UnloadSpritesAndText();
                    if (loadAction == -1) {
                        currentScene = -1;
                        isSceneLoaded = false;
                        loadAction = -2;
                    }
                    if (loadAction >= 0) {
                        currentScene = loadAction;
                        group.getChildren().add(canvas);
                        isSceneLoaded = true;
                        loadAction = -2;
                    }
                }

                if (currentScene != -1) {
                    manager.MouseInputMethods();
                    manager.ExecuteScripts();
                    manager.Colisions();
                    manager.Repulsions();
                    if(Input.isMouseClicked)Input.isMouseClicked=false;
                    manager.AnimationExecutions();
                    manager.DrawSprites(gc);
                    manager.DrawText();
                }
            } else {
                Platform.exit();
            }
        }
    }
    public static void LaunchGame(){
        InitializeGame();
    }
}
