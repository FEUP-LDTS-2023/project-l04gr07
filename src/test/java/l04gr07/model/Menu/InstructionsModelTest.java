package l04gr07.model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsModelTest {
    @Test
    public void testInstructionsModel() {
        InstructionsModel instructionsModel = new InstructionsModel();
        assertEquals(18, instructionsModel.getInstructions().size());
        assertEquals("Instructions", instructionsModel.getInstructions().get(0));
        assertEquals("Goal:", instructionsModel.getInstructions().get(1));
        assertEquals("being caught first", instructionsModel.getInstructions().get(5));
        assertEquals("Arrows -> move player1", instructionsModel.getInstructions().get(7));
        assertEquals("Huge IceCream mode", instructionsModel.getInstructions().get(14));
        assertEquals("( Press 'q' to EXIT )", instructionsModel.getInstructions().get(17));
    }
}
