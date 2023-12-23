package l04gr07.control;

import l04gr07.control.Audio.AudioController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AudioControllerTest {
    @Test
    void testSingletonInstance() {
        AudioController instance1 = AudioController.getInstance();
        AudioController instance2 = AudioController.getInstance();

        assertEquals(instance1, instance2, "Both instances should be the same");
    }
}