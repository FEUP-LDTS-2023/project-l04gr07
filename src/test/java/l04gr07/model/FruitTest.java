package l04gr07.model;

import l04gr07.model.Game.FieldElements.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FruitTest {
    @Test
    public void testGetPosition() {
        Fruit fruit = new Fruit(4, 21);
        Position position = fruit.getPosition();
        assertEquals(4, position.getx());
        assertEquals(21, position.gety());
    }
}
