package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.states.GameState;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class MainMenuController extends Controller implements Control{
    private long lastMovement=0;
    private final MainMenuModel mainMenuModel;
    private MainMenuState mainMenuState;

    public MainMenuController(MainMenuModel mainMenuModel, MainMenuState mainMenuState) {
        this.mainMenuModel = mainMenuModel;
        this.mainMenuState = mainMenuState;

    }
    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        System.out.println("PROCESSING KEYS");
        switch(key.getKeyType()){
            case ArrowUp -> mainMenuModel.previousOption();
            case ArrowDown -> mainMenuModel.nextOption();
            case Enter -> {
                System.out.println("ENTER");
                if (mainMenuModel.isSelected(2)) {exit(0);break;}
                if (mainMenuModel.isSelected(1)) {setControllerState(new InstructionState());}
                if (mainMenuModel.isSelected(0)){
                    System.out.println("START");mainMenuState.getGUI().close(); mainMenuState.stopRunning();setControllerState(new GameState());}

            }
            case Character -> {
                if(key.getCharacter()=='q' ||  key.getCharacter()=='Q')
                    exit(0);
            }
        }
        System.out.println(mainMenuModel.getCurrentOption());
    }
}
