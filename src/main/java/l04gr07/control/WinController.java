package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.states.DifficultyState;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;
import l04gr07.states.WinState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class WinController extends Controller implements Control{
    private final WinModel winModel;
    private WinState winState;

    public WinController(WinModel winModel, WinState winState) {
        this.winModel = winModel;
        this.winState = winState;

    }
    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        switch(key.getKeyType()){
            case ArrowUp -> winModel.previousOption();
            case ArrowDown -> winModel.nextOption();
            case Enter -> {
                if (winModel.isSelected(1)) {exit(0);break;}
                if (winModel.isSelected(0)){
                    winState.getGUI().close(); setControllerState(new MainMenuState());}

            }
            case Character -> {
                if(key.getCharacter()=='q' ||  key.getCharacter()=='Q')
                    exit(0);
            }
        }
    }
}
