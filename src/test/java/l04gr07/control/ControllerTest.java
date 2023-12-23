package l04gr07.control;

import l04gr07.states.MainMenuState;
import l04gr07.states.State;
import l04gr07.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTest {

    private Controller controller;
   // private State mockState;
    private Viewer mockViewer;

    @BeforeEach
    void setUp() {
        controller = new Controller();
       // mockState = mock(State.class);
        mockViewer = mock(Viewer.class);
    }

   /* @Test
    void setControllerState() throws IOException, URISyntaxException, FontFormatException {
        assertNull(controller.getControllerState());
        assertDoesNotThrow(() -> controller.setControllerState(mockState));
        assertEquals(mockState, controller.getControllerState());
        verify(mockState, times(1)).initializing(anyLong());
    }*/

    @Test
    void setViewer() {
        assertNull(controller.getViewer());
        controller.setViewer(mockViewer);
        assertEquals(mockViewer, controller.getViewer());
    }
}
