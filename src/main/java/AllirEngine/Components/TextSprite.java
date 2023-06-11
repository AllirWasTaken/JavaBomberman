package AllirEngine.Components;

import AllirEngine.GameManager;
import AllirEngine.Vector2;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextSprite {
    public Vector2 relativePosition;
    String displayedText;
    boolean visible=true;
    Font font;
    int fontSize=20;
    public Text text;
    public boolean loaded=false;


    public TextSprite(Vector2 relativePosition){
        this.relativePosition=relativePosition;
        displayedText="";
        CreateText();
    }
    public TextSprite(Vector2 relativePosition, String displayedText){
        this.relativePosition=relativePosition;
        this.displayedText=displayedText;
        CreateText();
    }

    public TextSprite(Vector2 relativePosition, String displayedText, int fontSize){
        this.relativePosition=relativePosition;
        this.displayedText=displayedText;
        this.fontSize=fontSize;
        CreateText();
    }

    private void CreateText(){
        text=new Text(displayedText);
        font = Font.loadFont(getClass().getResourceAsStream("/fonts/"+"Joystick.ttf"),fontSize/GameManager.manager.yConvSTG);
        text.setFont(font);
    }

    public void ChangeText(String newText){
        GameManager.RemoveTextFromScreen(text);
        displayedText=newText;
        text=new Text(displayedText);
        text.setFont(font);
        if(visible)loaded=false;
    }

    public void ChangeFontSize(int newSize){
        fontSize=newSize;
    }

    public void HideText(){
        if(visible){
            visible=false;
            GameManager.RemoveTextFromScreen(text);
        }
    }

    public void ShowText(){
        if(!visible){
            visible=true;
            loaded=false;
        }
    }


}
