package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Game.FieldElements.PlayerState.HugeIceCreamState;
import l04gr07.model.Game.FieldElements.PlayerState.PlayerState;
import l04gr07.model.Position;
import l04gr07.states.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class GameController implements Control {
    private Screen screen = null;
    //private Field field = new Field(25, 25);
    private Field field;
    private PlayerController playerController;
    private GameState gameState;
    private IceShot iceShot;
    private long time;
    private long lastMovement=0;
    private long lastMovementIce = 0;
    private PlayerState playerState;
    protected Boolean isHugeIceCream = false;
    protected Boolean iceCube = false;


    public GameController(GameState gameState, long time) {
        this.gameState = gameState;
        this.field = gameState.getModel().getField();
        this.playerState = field.getPlayerState();
        this.playerController = new PlayerController(field, this);
        this.time=time;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setTime(long time){
        //System.out.println("TIME UPDATED");
        this.time = time;}

    public void randomIceShot(IceShot iceShot){
        String direction = iceShot.getDirection();
      //  System.out.println("Random iceshot");
        time=System.currentTimeMillis();
        if (time - lastMovementIce > 500) {
           // for (IceShot iceShot : field.getIceShot())
                moveIceShot(iceShot, direction);
            lastMovementIce = time;
        }
    }

    public void moveIceShot(IceShot iceShot,String direction){
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
        if (field.isEmpty(nextPosition)){
            iceShot.setposition(nextPosition);
        }
        if(!field.isEmpty(nextPosition)){
            iceShot.setposition(new Position(-1,-1));}
    }
    public void randomEnemy(long time){
        time=System.currentTimeMillis();

        if (time - lastMovement > 500) {
            for (Enemy enemy : field.getEnemies())
                moveEnemy(enemy, enemy.getPosition().getRandomPosition());
            lastMovement = time;
        }
    }

    public void moveEnemy(Enemy enemy, Position position){
        if (field.isEmpty(position)){
            enemy.setposition(position);
        }
    }

    public void retrieveFruits() {
        if(field.getFruits().size() == 0){iceCube = true;notifyIceCubeObserver();}
        for (Fruit fruit : field.getFruits())
            if ((field.getPlayer1().getPosition().equals(fruit.getposition())) || (field.getPlayer2().getPosition().equals(fruit.getposition()))) {
                field.getFruits().remove(fruit);
                break;
            }
    }
    public void retrieveIceCube() throws IOException, URISyntaxException, FontFormatException {
            if ((field.getPlayer1().getPosition().equals(field.getIceCube().getposition())) || (field.getPlayer2().getPosition().equals(field.getIceCube().getposition()))) {
                Position position;
                if(field.getPlayer1().getPosition().equals(field.getIceCube().getposition())){position = field.getPlayer1().getPosition();}
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
    }
    public void IceShot(){
        if(field.getIceShot().getDirection()=="NO"){iceShot= new IceShot(-1,-1,"NO");}
        randomIceShot(field.getIceShot());
    }
}