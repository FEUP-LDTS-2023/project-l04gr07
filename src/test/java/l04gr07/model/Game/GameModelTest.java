package l04gr07.model.Game;

import l04gr07.model.Game.Difficulty.DifficultyStrategy;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Difficulty.HardDifficulty;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class GameModelTest {
    @Test
    public void testGameModelEasy() {
        try {
            DifficultyStrategy difficultyStrategy = new EasyDifficulty();
            GameModel gameModel = new GameModel(difficultyStrategy);
            assertNotNull(gameModel.getField());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGameModelHard() throws IOException {
            DifficultyStrategy difficultyStrategy = new HardDifficulty();
            GameModel gameModel = new GameModel(difficultyStrategy);
            assertNotNull(gameModel.getField());
    }
}
