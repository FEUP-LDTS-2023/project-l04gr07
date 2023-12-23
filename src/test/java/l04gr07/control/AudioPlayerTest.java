package l04gr07.control;

import l04gr07.control.Audio.AudioPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AudioPlayerTest {
    @Test
    void testPlay() {
        String audioFilePath = "src/main/resources/background.wav";
        assertDoesNotThrow(() -> {
            AudioPlayer audioPlayer = new AudioPlayer(audioFilePath);
            audioPlayer.play();
        });
    }
}
