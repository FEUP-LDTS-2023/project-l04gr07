package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.states.GameOverState;
import l04gr07.states.InstructionState;

import static java.lang.System.exit;

public class GameOverController implements Control{
    private final GameOverModel gameOverModel;
    private GameOverState gameOverState;
    public GameOverController(GameOverModel gameOverModel, GameOverState gameOverState) {
        this.gameOverModel = gameOverModel;
        this.gameOverState=gameOverState;

    }
    @Override
    public void processKey(KeyStroke key) {

            if(key.getCharacter()=='q' ||  key.getCharacter()=='Q')
                exit(0);

    }
}
