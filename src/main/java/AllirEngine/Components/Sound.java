package AllirEngine.Components;

import AllirEngine.GameManager;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public class Sound {
    AudioClip soundFile;
    MediaPlayer soundPlayer;
    public Sound(String filename){
        soundFile = new AudioClip(getClass().getResource("/sound/"+filename).toExternalForm());
    }

    public void PlaySound(){
        if(GameManager.playSound)soundFile.play();
    }
}
