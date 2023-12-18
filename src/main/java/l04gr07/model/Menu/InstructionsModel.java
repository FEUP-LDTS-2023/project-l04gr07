package l04gr07.model.Menu;

import l04gr07.model.Model;
import java.util.Arrays;
import java.util.List;

public class InstructionsModel implements Model {

    private final List<String> instructions ;

    public InstructionsModel(){
        this.instructions = Arrays.asList(
            "Instructions",
            "Goal:",
            "Collect all fruits and catch the ice cube",
            "to enter in Huge IceCream mode. Now, work",
            "together to kill all monsters without","being caught first",
            "Controls:",
            "Arrows -> move player1",
            "'WASD' -> move player2",
            "'WASD' -> move player in Huge Icecream", "mode",
            "'Enter' -> break/create walls by player1",
            "'E' -> break/create walls by player2",
            "'E/Enter' -> break/create walls by player in", "Huge IceCream mode",
            "Arrows -> throw iceshot by player in", "Huge Icecream mode",
            "( Press 'q' to EXIT )"
        );
    }
    public List<String>  getInstructions() {
        return instructions;
    }

}
