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
    GameOverController controller=new GameOverController();
    GameOverState state=new GameOverState();
    LanternGUI gui=new LanternGUI();
    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        gui.createGameOverScreen(10,12);
        state.setGUI(gui);
        System.out.println(KeyStroke.fromString("q").getCharacter());
        assertNotNull(state.getGUI().getScreen());
    }

    @Test
    public void testProcessKeyCharacter() throws IOException, URISyntaxException, FontFormatException {
        System.out.println(KeyStroke.fromString("q").getCharacter());
        state.setGUI(gui);
        KeyStroke key=KeyStroke.fromString("q");
       // controller.processKey(key, gui);
       // assertThrows(IOException.class, () -> controller.processKey(key, gui));
     //   assertNull(state.getGUI().getScreen());
    }
}
