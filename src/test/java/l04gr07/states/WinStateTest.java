package l04gr07.states;

import l04gr07.control.GameOverController;
import l04gr07.control.WinController;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.view.GameView.GameOverView;
import l04gr07.view.GameView.WinView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class WinStateTest {
    private WinState winState;

    @BeforeEach
    public void setUp() throws Exception{
        winState = new WinState();
    }

    @Test
    public void testGetters() throws Exception{
        winState.initializing(200);
        assertNotNull(winState.getViewer());
        assertNotNull(winState.getControl());
        assertNotNull(winState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        winState.initializing(200);
        assertTrue(winState.getViewer() instanceof WinView);
        assertTrue(winState.getControl() instanceof WinController);
        assertTrue(winState.getModel() instanceof WinModel);
    }
    @Test
    public void testRun() throws Exception{
        WinState winState = mock(WinState.class);
        when(winState.getViewer()).thenReturn(mock(WinView.class));
        when(winState.getControl()).thenReturn(mock(WinController.class));
        when(winState.getModel()).thenReturn(mock(WinModel.class));
        winState.run(0);
        verify(winState, atLeastOnce()).run(0);
    }
}
