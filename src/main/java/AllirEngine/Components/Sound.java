package AllirEngine.Components;

import AllirEngine.GameManager;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    AudioClip soundFile;
    MediaPlayer soundPlayer;
    public Sound(String filename){
        soundFile = new AudioClip(getClass().getResource("/sound/"+filename).toExternalForm());
    }

    public void PlaySound(){
        if(GameManager.playSound)soundFile.play();
    }

    public void playMusic(String filename){
        String path = getClass().getResource("/sound/"+filename).getPath();
        Media media = new Media(new File(path).toURI().toString());
        soundPlayer=new MediaPlayer(media);
        soundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        soundPlayer.play();
    }

    public void PauseMusic(){
        soundPlayer.pause();
    }
    public void ResumeMusic(){
        soundPlayer.play();;
    }
}
