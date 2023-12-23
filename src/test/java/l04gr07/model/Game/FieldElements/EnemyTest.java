package l04gr07.model.Game.FieldElements;

import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {
    @Test
    public void testEnemy() {
        Enemy enemy = new Enemy(3, 6);
        Position position = enemy.getPosition();
        assertEquals(3, position.getx());
        assertEquals(6, position.gety());
    }
}
