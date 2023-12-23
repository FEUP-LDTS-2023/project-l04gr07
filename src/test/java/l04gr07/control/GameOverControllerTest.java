package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.states.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameOverControllerTest {
    GameOverState state=new GameOverState();
    LanternGUI gui=mock(LanternGUI.class);

    @Test
    public void testProcessKeyCharacter() throws IOException, URISyntaxException, FontFormatException {
        state.setGUI(gui);
        verify(gui, never()).close();
        KeyStroke key=KeyStroke.fromString("a");
        GameOverController controller = new GameOverController(state);
        controller.processKey(key);
        verify(state.getGUI(), never()).close();
    }
}
