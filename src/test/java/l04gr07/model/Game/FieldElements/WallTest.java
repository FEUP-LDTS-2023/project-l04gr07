package l04gr07.model.Game.FieldElements;

import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    public void testGetPosition() {
        Wall wall = new Wall(4, 21);
        assertEquals(4, wall.getPosition().getx());
        wall.setPosition(new Position(2,19));
        assertEquals(19, wall.getPosition().gety());
    }
}
