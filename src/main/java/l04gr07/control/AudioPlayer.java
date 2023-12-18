package l04gr07.control;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class AudioPlayer {
    protected Clip clip;
    protected FloatControl fc;

    public AudioPlayer(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip.setFramePosition(0);
        fc.setValue(-5.0f);
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void volUp() {
        if (fc.getValue() < 4.206) fc.setValue(fc.getValue() + 2.0f);
    }

    public void volDown() {
        if (fc.getValue() > -78.0) fc.setValue(fc.getValue() -2.0f);
    }



}