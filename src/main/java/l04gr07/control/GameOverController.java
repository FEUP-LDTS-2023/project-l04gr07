package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.states.GameOverState;

import java.io.IOException;

import static java.lang.System.exit;

public class GameOverController implements Control{
    private GameOverState gameOverState;
    public GameOverController(GameOverState gameOverState){
        this.gameOverState = gameOverState;
    }
    @Override
    public void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'q' || key.getCharacter() == 'Q')){
            gameOverState.getGUI().close();exit(0);
        }
    }

    public void setGameOverState(GameOverState gameOverState) {
        this.gameOverState = gameOverState;
    }

    public GameOverState getGameOverState() {
        return gameOverState;
    }
}
