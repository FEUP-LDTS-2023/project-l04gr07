package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.states.InstructionState;

import java.io.IOException;

public class InstructionController implements Control{
    private final InstructionsModel instructionsModel;
    private InstructionState instructionState;
    public InstructionController(InstructionsModel instructionsModel, InstructionState instructionState) {
        this.instructionsModel = instructionsModel;
        this.instructionState=instructionState;
    }
    @Override
    public void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            instructionState.getGUI().getScreen().close();
        }
    }
}
