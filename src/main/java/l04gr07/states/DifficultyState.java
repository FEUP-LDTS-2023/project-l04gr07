package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.DifficultyController;
import l04gr07.control.MainMenuController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.DifficultyView;
import l04gr07.view.GameView.MainMenuView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class DifficultyState extends State{
    private DifficultyView difficultyView;
    private DifficultyModel difficultyModel;
    private DifficultyController difficultyControl;

    private LanternGUI gui;
    private Boolean running = false;

    @Override
    public Viewer getViewer() {
        return difficultyView;
    }
    @Override
    public Control getControl() {
        return difficultyControl;
    }

    @Override
    public Model getModel() {
        return difficultyModel;
    }

    @Override
    public boolean isRunning(){return running;}
    @Override
    public void stopRunning(){running = false;}

    @Override
    public State nextState(){return new GameState();}

    public LanternGUI getGUI(){return gui;}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        running = true;
        difficultyModel = new DifficultyModel();
        gui = new LanternGUI();
        gui.createDifficultyScreen(40,30);
        difficultyView = new DifficultyView(difficultyModel, gui.getScreen());
        difficultyControl = new DifficultyController(difficultyModel,this);
        run(time);
    }

    @Override
    public void run(long time) throws IOException, URISyntaxException, FontFormatException {
        while (true){
            difficultyView.draw();
            KeyStroke key = gui.getScreen().readInput();
            difficultyControl.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }
}