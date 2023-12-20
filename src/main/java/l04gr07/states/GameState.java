package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.GameController;
import l04gr07.control.PlayerController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Difficulty.DifficultyStrategy;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Difficulty.HardDifficulty;
import l04gr07.model.Game.GameModel;
import l04gr07.view.GameView.GameView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class GameState extends State {
    private GameView gameView;
    private GameModel gameModel;

    private GameController gameControl;
    private PlayerController playerControl;
    private LanternGUI gui;

    private Boolean running = false;
    public GameState(){}

    public GameState(DifficultyStrategy difficulty) throws IOException {
        super();
        gameModel = new GameModel(difficulty);
    }

    @Override
    public State nextState(){return new GameOverState();}
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
    public void startRunning(){running = true;}

    @Override
    public void stopRunning(){running = false;}
    public LanternGUI getGUI(){return gui;}


    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        running = true;
        gui = new LanternGUI();
        gui.createGameScreen(55,23);
        gameView = new GameView(gameModel, gui.getScreen());
        gameControl = new GameController(this,gameModel, time);
    }
    private static final int FPS = 60;
    private static final long frameTime = 1000 / FPS;


    public void run(long time) throws IOException, URISyntaxException, FontFormatException {
        while (true){
            long currentTime=System.currentTimeMillis();
            gameControl.randomEnemy(time);
            gameControl.setTime(time);
            gameControl.IceShot();
            gameView.draw();
            KeyStroke key = gui.getScreen().pollInput();
            if(key!=null){
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q' &&key.getCharacter() == 'Q'){
                exit(0);gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
                gameControl.processKey(key);}

            long elapsedTime = System.currentTimeMillis() - currentTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {

            }
        }
    }



}
