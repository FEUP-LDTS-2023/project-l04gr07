package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;

public class InstructionController implements Control{
    private final InstructionsModel instructionsModel;
    private InstructionState instructionState;
    public InstructionController(InstructionsModel instructionsModel, InstructionState instructionState) {
        this.instructionsModel = instructionsModel;
        this.instructionState=instructionState;

    }
    @Override
    public void processKey(KeyStroke key) {

    }
}
