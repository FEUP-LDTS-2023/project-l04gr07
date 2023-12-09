package l04gr07.states;

import l04gr07.control.PlayerController;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.NormalPlayerState;
import l04gr07.view.ElementsView.PlayerViewer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NormalPlayerStateTest {
    /*
    @Test
    void testGetViewer() {
        NormalPlayerState normalPlayerState = new NormalPlayerState();
        List<PlayerViewer> viewers = normalPlayerState.getViewer();
        assertNotNull(viewers);
        assertTrue(viewers.isEmpty());
    }

    @Test
    void testGetControl() {
        NormalPlayerState normalPlayerState = new NormalPlayerState();
        List<PlayerController> controllers = normalPlayerState.getControl();
        assertNotNull(controllers);
        assertTrue(controllers.isEmpty());
    }

    @Test
    void testGetModel() {
        NormalPlayerState normalPlayerState = new NormalPlayerState();
        List<Player> model = normalPlayerState.getModel();
        assertNotNull(model);
        assertTrue(model.isEmpty());
    }

    @Test
    void testInitializing() {
        NormalPlayerState normalPlayerState = new NormalPlayerState();
        assertDoesNotThrow(() -> normalPlayerState.initializing());
        List<Player> models = normalPlayerState.getModel();
        assertNotNull(models);
        assertEquals(2, models.size());
    }

     */
}
