package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.GameController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.GameView;
import l04gr07.view.Viewer;

import java.io.IOException;

import static java.lang.System.exit;

public class GameState extends State {
    private GameView gameView;
    private GameModel gameModel;

    private GameController gameControl;
    private LanternGUI gui;

    private Boolean running = false;
    @Override
    public State nextState(){return new EndScreenState();}
    @Override
    public Viewer getViewer() {
        return gameView;
    }

    @Override
    public Control getControl() {
        return gameControl ;
    }

    @Override
    public GameModel getModel() {
        return gameModel;
    }
    @Override
    public boolean isRunning(){return running;}
    @Override
    public void stopRunning(){running = false;}


    @Override
    public void initializing() throws IOException {
        running = true;
        gameModel = new GameModel(new EasyDifficulty());
        gui = new LanternGUI();
        gui.createGameScreen(55,23);
        gameView = new GameView(gameModel, gui.getScreen());
        gameControl = new GameController(this);
        run();
    }
    public void run() throws IOException{
        while (true){
            gameView.draw();
            KeyStroke key = gui.getScreen().readInput();
            gameControl.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q' &&key.getCharacter() == 'Q'){
                exit(0);gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }

}
