package l04gr07.control.Audio;

public class AudioController {
    private static AudioController instance;
    private AudioPlayer audio;

    private AudioController(){};

    public static AudioController getInstance(){
        if(instance==null){
            instance=new AudioController();
        }
        return instance;
    }

    public void playAudio(String path){
        audio=new AudioPlayer(path);
        audio.play();
    }

}
