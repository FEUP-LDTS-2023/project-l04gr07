package l04gr07.control;

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
