package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Difficulty.HardDifficulty;
import l04gr07.model.Game.Difficulty.MediumDifficulty;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.states.DifficultyState;
import l04gr07.states.GameState;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class DifficultyController extends Controller implements Control{
    private final DifficultyModel difficultyModel;
    private DifficultyState difficultyState;

    public DifficultyController(DifficultyModel difficultyModel, DifficultyState difficultyState) {
        this.difficultyModel = difficultyModel;
        this.difficultyState = difficultyState;

    }
    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        switch(key.getKeyType()){
            case ArrowUp -> difficultyModel.previousOption();
            case ArrowDown -> difficultyModel.nextOption();
            case Enter -> {
                if (difficultyModel.isSelected(3)) {difficultyState.getGUI().close(); difficultyState.stopRunning();setControllerState(new MainMenuState());}
                if (difficultyModel.isSelected(2)) {difficultyState.getGUI().close(); difficultyState.stopRunning();setControllerState(new GameState(new HardDifficulty()));}
                if (difficultyModel.isSelected(1)) {difficultyState.getGUI().close(); difficultyState.stopRunning();setControllerState(new GameState(new MediumDifficulty()));}
                if (difficultyModel.isSelected(0)) {difficultyState.getGUI().close(); difficultyState.stopRunning();setControllerState(new GameState(new EasyDifficulty()));}
            }
            case Character -> {
                if(key.getCharacter()=='q' ||  key.getCharacter()=='Q') exit(0);
            }
        }
    }
}
