package l04gr07.states;

import com.googlecode.lanterna.input.KeyType;
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
        difficultyState.initializing(200);
    }

    @Test
    public void testGetters() throws Exception{
        assertNotNull(difficultyState.getViewer());
        assertNotNull(difficultyState.getControl());
        assertNotNull(difficultyState.getModel());
        assertNotNull(difficultyState.getGUI());
    }

    @Test
    public void testInitializing() throws Exception{
        assertTrue(difficultyState.getViewer() instanceof DifficultyView);
        assertTrue(difficultyState.getControl() instanceof DifficultyController);
        assertTrue(difficultyState.getModel() instanceof DifficultyModel);
    }

    @Test
    public void testRun() throws Exception{
        difficultyState = mock(DifficultyState.class);
        DifficultyState difficultyState = mock(DifficultyState.class);
        when(difficultyState.getViewer()).thenReturn(mock(DifficultyView.class));
        when(difficultyState.getControl()).thenReturn(mock(DifficultyController.class));
        when(difficultyState.getModel()).thenReturn(mock(DifficultyModel.class));
        difficultyState.run(200);
        verify(difficultyState, times(1)).run(200);
    }
}
