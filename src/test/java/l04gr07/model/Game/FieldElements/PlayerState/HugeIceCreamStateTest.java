package l04gr07.model.Game.FieldElements.PlayerState;

import l04gr07.control.PlayerController;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.HugeIceCreamState;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.PlayerViewer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HugeIceCreamStateTest {
    Position position= new Position(4,6);

    @Test
    void testGetViewer() {
        HugeIceCreamState hState = new HugeIceCreamState(position);
        List<PlayerViewer> viewers = hState.getViewer();
        assertNotNull(viewers);
        assertTrue(viewers.isEmpty());
    }

    @Test
    void testGetControl() {
        HugeIceCreamState hState = new HugeIceCreamState(position);
        List<PlayerController> controllers = hState.getControl();
        assertNotNull(controllers);
        assertTrue(controllers.isEmpty());
    }

    @Test
    void testGetModel() {
        HugeIceCreamState hState = new HugeIceCreamState(position);
        List<Player> model = hState.getModel();
        assertNotNull(model);
        assertTrue(model.isEmpty());
    }

    @Test
    void testInitializing() {
        HugeIceCreamState hState = new HugeIceCreamState(position);
        assertDoesNotThrow(() -> hState.initializing());
        List<Player> models = hState.getModel();
        assertNotNull(models);
        assertEquals(1, models.size());
    }

}
