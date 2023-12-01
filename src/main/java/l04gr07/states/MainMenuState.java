package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.MainMenuController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.MainMenuView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuState extends State{
    private MainMenuView mainMenuView;
    private MainMenuModel mainMenuModel;
    private MainMenuController mainMenuControl;

    private LanternGUI gui;
    private Boolean running = false;

    @Override
    public Viewer getViewer() {
        return mainMenuView;
    }
    @Override
    public Control getControl() {
        return mainMenuControl;
    }

    @Override
    public Model getModel() {
        return mainMenuModel;
    }

    @Override
    public boolean isRunning(){return running;}
    @Override
    public void stopRunning(){running = false;}

    @Override
    public State nextState(){return new GameState();}

    public LanternGUI getGUI(){return gui;}

    @Override
    public void initializing() throws IOException, URISyntaxException, FontFormatException {
        running = true;
        mainMenuModel = new MainMenuModel();
        gui = new LanternGUI();
        gui.createMenuScreen(40,30);
        mainMenuView = new MainMenuView(mainMenuModel, gui.getScreen());
        mainMenuControl = new MainMenuController(mainMenuModel,this);
        run();
    }

    @Override
    public void run() throws IOException, URISyntaxException, FontFormatException {
        while (true){
            mainMenuView.draw();
            KeyStroke key = gui.getScreen().readInput();
            mainMenuControl.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }
}
