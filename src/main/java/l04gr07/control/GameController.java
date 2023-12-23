package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.HugeIceCreamState;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Position;
import l04gr07.states.GameOverState;
import l04gr07.states.GameState;
import l04gr07.states.WinState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;


public class GameController extends Controller implements Control {
    private Field field;
    private PlayerController playerController;
    private GameState gameState;
    private long time;
    private long lastMovement=0;
    private long lastMovementIce = 0;
    protected Boolean isHugeIceCream = false;
    protected Boolean iceCube = false;



    public GameController(GameState gameState, GameModel gameModel, long time) {
        this.gameState = gameState;
        this.field = gameState.getModel().getField();

        this.playerController = new PlayerController(field, this);
        this.time=time;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setTime(long time){
        this.time = time;}

    public long getTime() {
        return time;
    }

    public long getLastMovementIce() {
        return lastMovementIce;
    }

    public long getLastMovement() {
        return lastMovement;
    }
    public boolean getIceCube() {
        return iceCube;
    }

    public void randomIceShot(IceShot iceShot) throws IOException, URISyntaxException, FontFormatException {
        String direction = iceShot.getDirection();
        time=System.currentTimeMillis();
        if (time - lastMovementIce > 200) {
                moveIceShot(iceShot, direction);
            lastMovementIce = time;
        }
    }


    public void moveIceShot(IceShot iceShot,String direction) throws IOException, URISyntaxException, FontFormatException {
        Position nextPosition = iceShot.getPosition();
        switch(direction){
            case "UP": {
                nextPosition = new Position(iceShot.getPosition().getx(),iceShot.getPosition().gety()-1);
                break;}
            case "DOWN": {
                nextPosition = new Position(iceShot.getPosition().getx(),iceShot.getPosition().gety()+1);
                break;}
            case "LEFT": {
                nextPosition = new Position(iceShot.getPosition().getx()-1,iceShot.getPosition().gety());
                break;}
            case "RIGHT": {
                nextPosition = new Position(iceShot.getPosition().getx()+1,iceShot.getPosition().gety());
                break;}
            case "NO":{break;}
            }
        if (field.isEmpty(nextPosition)&&field.isMonster(nextPosition) == null){
            iceShot.setposition(nextPosition);
        }
        if(field.isMonster(nextPosition)!=null) {
            AudioController.getInstance().playAudio("./src/main/resources/KillMonster.wav");
            field.getEnemies().remove(field.isMonster(nextPosition));
            if(field.getEnemies().size()==0){
                gameState.getGUI().close(); setControllerState(new WinState());
            }
        }
        if(!field.isEmpty(nextPosition)){
            iceShot.setposition(new Position(-1,-1));}
    }
    public void randomEnemy(long time) throws IOException, URISyntaxException, FontFormatException {
        time=System.currentTimeMillis();

        if (time - lastMovement > field.getSpeed()) {
            for (Enemy enemy : field.getEnemies())
                moveEnemy(enemy, enemy.getPosition().getRandomPosition());
            lastMovement = time;
        }
    }

    public void moveEnemy(Enemy enemy, Position position) throws IOException, URISyntaxException, FontFormatException {
        if (field.isEmpty(position)){
            enemy.setposition(position);
            for(Player player: field.getPlayers()){
                if(player.getPosition().equal(position)){
                    gameState.getGUI().close(); setControllerState(new GameOverState());
                }
            }
        }
    }

    public void retrieveFruits() {
        if(field.getFruits().isEmpty()){
            iceCube = true;notifyIceCubeObserver();}
        for (Fruit fruit : field.getFruits())
            if (field.getPlayer1().getPosition().equal(fruit.getposition()) || field.getPlayer2().getPosition().equal(fruit.getposition())) {
                AudioController.getInstance().playAudio("./src/main/resources/CollectedFruit.wav");
                field.getFruits().remove(fruit);
                break;
            }
    }
    public void retrieveIceCube() throws IOException, URISyntaxException, FontFormatException {
            if (field.getPlayer1().getPosition().equal(field.getIceCube().getposition()) || field.getPlayer2().getPosition().equal(field.getIceCube().getposition())) {
                AudioController.getInstance().playAudio("./src/main/resources/getIceCube.wav");
                Position position;
                if(field.getPlayer1().getPosition().equal(field.getIceCube().getposition())){position = field.getPlayer1().getPosition();}
                else{position = field.getPlayer2().getPosition();}
                iceCube = false;notifyIceCubeObserver();
                isHugeIceCream = true;playerController.setHugeIceCream(true);
                field.setIceCube(null);
                field.setPlayerState(new HugeIceCreamState(position));
                field.getPlayerState().initializing();
                field.setPlayers(field.getPlayerState().getModel());

            }
    }
    public void notifyIceCubeObserver(){
        if(iceCube){gameState.getViewer().spawnIceCube();}
        else gameState.getViewer().deSpawnIceCube(); }

    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        playerController.processKey(key);
        if(!iceCube && field.getIceCube()!=null && !isHugeIceCream) retrieveFruits();
        if(iceCube && !isHugeIceCream){retrieveIceCube();}
        if (key.getKeyType() == KeyType.Character && (key.getCharacter() == 'q' || key.getCharacter() == 'Q')){
            gameState.getGUI().close();exit(0);
        }
    }
    public void IceShot() throws IOException, URISyntaxException, FontFormatException {
        randomIceShot(field.getIceShot());
    }

}