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
    LanternGUI gui=new LanternGUI();
    @Test
    public void testProcessKeyCharacter() throws IOException, URISyntaxException, FontFormatException {
        gui.createGameOverScreen(10,12);
        state.setGUI(gui);
        assertNotNull(state.getGUI().getScreen());
        state.setGUI(gui);
        KeyStroke key;
        key=KeyStroke.fromString("a");
        assertNotNull(state.getGUI().getScreen());
        assertNotNull(state.getGUI().getScreen());
        GameOverController controller = new GameOverController(state);
        controller.setGameOverState(state);
        controller.processKey(key);
        assertNotNull(controller.getGameOverState().getGUI());
    }
}
