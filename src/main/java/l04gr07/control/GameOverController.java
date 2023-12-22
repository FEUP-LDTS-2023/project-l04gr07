package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.states.GameOverState;

import java.io.IOException;

import static java.lang.System.exit;

public class GameOverController {
    public void processKey(KeyStroke key, LanternGUI gui) throws IOException {
        if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'q' || key.getCharacter() == 'Q')){
            gui.close();
            exit(0);
        }
        if (key.getKeyType() == KeyType.EOF){exit(0);}
    }
}
