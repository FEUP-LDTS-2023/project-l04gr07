package l04gr07.model.Menu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DifficultyModelTest {
        @Test
        public void testDifficultyModel() {
            DifficultyModel difficultyModel = new DifficultyModel();
            assertEquals(4, difficultyModel.getNumberOptions());
            assertEquals("Easy", difficultyModel.getOption(0));
            assertEquals("Hard", difficultyModel.getOption(2));
            assertFalse(difficultyModel.isSelected(2));
            assertFalse(difficultyModel.isSelected(1));
            assertEquals(0, difficultyModel.getCurrentOption());
            difficultyModel.nextOption();
            assertEquals(1, difficultyModel.getCurrentOption());
            assertTrue(difficultyModel.isSelected(1));
            assertFalse(difficultyModel.isSelected(0));
            difficultyModel.previousOption();
            assertEquals(0, difficultyModel.getCurrentOption());
            assertTrue(difficultyModel.isSelected(0));
            difficultyModel.setRunning(true);
            assertTrue(difficultyModel.getRunning());
         }
}
