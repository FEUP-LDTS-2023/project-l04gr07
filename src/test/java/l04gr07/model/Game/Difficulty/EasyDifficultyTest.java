package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EasyDifficultyTest {

    @Test
    public void testCreateField() {
        EasyDifficulty easyDifficulty = new EasyDifficulty();
        Field field = easyDifficulty.createField();
        assertNotNull(field);
        assertEquals(10, field.getIceCube().getPosition().getx());
        assertEquals(10, field.getIceCube().getPosition().gety());
        Position p1Position= field.getPlayer1().getPosition();
        assertNotNull(p1Position);
        assertEquals(30, p1Position.getx());
        assertEquals(8, p1Position.gety());
        Position p2Pos = field.getPlayer2().getPosition();
        assertNotNull(p2Pos);
        assertEquals(30, p2Pos.getx());
        assertEquals(15, p2Pos.gety());
    }
}