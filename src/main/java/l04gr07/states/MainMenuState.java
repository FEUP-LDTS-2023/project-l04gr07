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

    public LanternGUI getGUI(){return gui;}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        mainMenuModel = new MainMenuModel();
        gui = new LanternGUI();
        gui.createMenuScreen(40,30);
        mainMenuView = new MainMenuView(mainMenuModel, gui.getScreen());
        mainMenuControl = new MainMenuController(mainMenuModel,this);
    }

    @Override
    public void run(long time) throws IOException, URISyntaxException, FontFormatException {
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

    public void stopRunning() throws IOException {
        gui.getScreen().close();
    }
}
