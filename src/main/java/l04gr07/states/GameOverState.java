package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.GameOverController;
import l04gr07.control.InstructionController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.GameOverView;
import l04gr07.view.GameView.InstructionView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState extends State{
    private GameOverView gameOverView;
    private GameOverModel gameOverModel;
    private GameOverController gameOverController;

    private LanternGUI gui;
    private Boolean running=false;
    @Override
    public Viewer getViewer() {
        return null;
    }

    @Override
    public Control getControl() {
        return null;
    }

    @Override
    public Model getModel() {
        return null;
    }
    @Override
    public boolean isRunning(){return running;}
    @Override
    public void stopRunning(){running = false;}

    @Override
    public State nextState(){return new EndScreenState();}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        running = true;
        gameOverModel = new GameOverModel();
        gui = new LanternGUI();
        gui.createGameOverScreen(40,30);
        gameOverView = new GameOverView(gameOverModel, gui.getScreen());
        gameOverController = new GameOverController(gameOverModel, this);
        run(time);
    }

    @Override
    public void run(long time) throws IOException {
        while (true){
            gameOverView.draw();
            KeyStroke key = gui.getScreen().readInput();
            gameOverController.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }
}
