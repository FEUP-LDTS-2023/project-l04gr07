package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Difficulty.MediumDifficulty;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MediumDifficultyTest {
    @Test
    public void testCreateField() {
        MediumDifficulty mediumDifficulty = new MediumDifficulty();
        Field field = mediumDifficulty.createField();
        assertNotNull(field);
        assertEquals(2, field.getIceCube().getPosition().getx());
        assertEquals(2, field.getIceCube().getPosition().gety());
        Position p1Position= field.getPlayer1().getPosition();
        assertNotNull(p1Position);
        assertEquals(4, p1Position.getx());
        assertEquals(3, p1Position.gety());
        Position p2Pos = field.getPlayer2().getPosition();
        assertNotNull(p2Pos);
        assertEquals(4, p2Pos.getx());
        assertEquals(20, p2Pos.gety());
    }
}
