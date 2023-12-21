package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionController extends Controller implements Control{
    private InstructionState instructionState;
    public InstructionController( InstructionState instructionState) {
        this.instructionState=instructionState;
    }
    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            instructionState.getGUI().getScreen().close();setControllerState(new MainMenuState());
        }
    }
}
