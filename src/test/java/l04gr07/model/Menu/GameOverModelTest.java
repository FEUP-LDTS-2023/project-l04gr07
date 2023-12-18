package l04gr07.model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverModelTest {
    @Test
    public void testGameOverModel() {
        GameOverModel gameOverModel = new GameOverModel();
        assertEquals(2, gameOverModel.getGameOverText().size());
        assertEquals("\t\tGame Over", gameOverModel.getGameOverText().get(0));
        assertEquals("Press 'q' to exit", gameOverModel.getGameOverText().get(1));
    }
}
