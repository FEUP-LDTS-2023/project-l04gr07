package l04gr07.control;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class AudioControllerTest {
    @Test
    void testSingletonInstance() {
        AudioController instance1 = AudioController.getInstance();
        AudioController instance2 = AudioController.getInstance();

        assertEquals(instance1, instance2, "Both instances should be the same");
    }
}