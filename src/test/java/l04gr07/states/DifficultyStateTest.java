package l04gr07.states;

import l04gr07.control.DifficultyController;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.view.GameView.DifficultyView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import com.googlecode.lanterna.input.KeyStroke;

public class DifficultyStateTest {
    private DifficultyState difficultyState;

    @BeforeEach
    public void setUp() throws Exception{
        difficultyState = new DifficultyState();
    }

    @Test
    public void testGetters() throws Exception{
        difficultyState.initializing(200);
        assertNotNull(difficultyState.getViewer());
        assertNotNull(difficultyState.getControl());
        assertNotNull(difficultyState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        difficultyState.initializing(200);
        assertTrue(difficultyState.getViewer() instanceof DifficultyView);
        assertTrue(difficultyState.getControl() instanceof DifficultyController);
        assertTrue(difficultyState.getModel() instanceof DifficultyModel);
    }

}
