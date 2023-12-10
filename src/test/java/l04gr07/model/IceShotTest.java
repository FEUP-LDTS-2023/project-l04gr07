package l04gr07.model;

import l04gr07.model.Game.FieldElements.IceShot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IceShotTest {
    @Test
    public void testIceShot() {
        IceShot iceShot = new IceShot(4, 21, "LEFT");
        Position position = iceShot.getPosition();
        assertEquals(4, position.getx());
        assertEquals(21, position.gety());
        assertEquals("LEFT", iceShot.getDirection());
        assertNotEquals("NO", iceShot.getDirection());
    }
}
