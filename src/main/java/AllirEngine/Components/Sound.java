package AllirEngine.Components;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public class Sound {
    AudioClip soundFile;
    MediaPlayer soundPlayer;
    public Sound(String filename){
        soundFile = new AudioClip(getClass().getResource("/sound/"+filename).toExternalForm());
    }

    public void PlaySound(){
        soundFile.play();
    }
}
