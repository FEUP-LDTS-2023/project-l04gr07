package l04gr07.states;

import l04gr07.control.PlayerController;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.NormalPlayerState;
import l04gr07.view.ElementsView.PlayerViewer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NormalPlayerStateTest {
        Player p1= new Player(3,3);
        Player p2= new Player(4,6);

    @Test
    void testGetViewer() {
        NormalPlayerState normalPlayerState = new NormalPlayerState(p1.getPosition(),p2.getPosition());
        List<PlayerViewer> viewers = normalPlayerState.getViewer();
        assertNotNull(viewers);
        assertTrue(viewers.isEmpty());
    }

    @Test
    void testGetControl() {
        NormalPlayerState normalPlayerState = new NormalPlayerState(p1.getPosition(),p2.getPosition());
        List<PlayerController> controllers = normalPlayerState.getControl();
        assertNotNull(controllers);
        assertTrue(controllers.isEmpty());
    }

    @Test
    void testGetModel() {
        NormalPlayerState normalPlayerState = new NormalPlayerState(p1.getPosition(),p2.getPosition());
        List<Player> model = normalPlayerState.getModel();
        assertNotNull(model);
        assertTrue(model.isEmpty());
    }

    @Test
    void testInitializing() {
        NormalPlayerState normalPlayerState = new NormalPlayerState(p1.getPosition(),p2.getPosition());
        assertDoesNotThrow(() -> normalPlayerState.initializing());
        List<Player> models = normalPlayerState.getModel();
        assertNotNull(models);
        assertEquals(2, models.size());
    }


}
