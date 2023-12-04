package l04gr07.control;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.HugeIceCreamState;
import l04gr07.model.Game.FieldElements.PlayerState.PlayerState;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;
import l04gr07.states.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static java.lang.System.exit;


public class GameController implements Control {
    private Screen screen = null;
    //private Field field = new Field(25, 25);
    private Field field;
    private PlayerController playerController;
    private GameState gameState;

    private long lastMovement=0;
    private PlayerState playerState;
    protected Boolean isHugeIceCream = false;
    protected Boolean iceCube = false;


    public GameController(GameState gameState) {
        this.gameState = gameState;
        this.field = gameState.getModel().getField();
        this.playerState = field.getPlayerState();
        this.playerController = new PlayerController(field);
    }

    public boolean canPlayerMove(Position position) {
        if ((position.getx() < 0) || (position.getx() > field.getWidth() - 1)) return false;
        if ((position.gety() > field.getHeight() - 1) || (position.gety() < 0)) return false;
        for (Wall wall : field.getWalls())
            if (wall.getPosition().equals(position)) {
                return false;
            }
        for(Enemy enemy: field.getEnemies()){
            if(enemy.getPosition().equals(position)){
                System.exit(0);
            }
        }
        return true;
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
            if(field.getPlayer1().getPosition().equals(enemy.getPosition().getRandomPosition()) || field.getPlayer2().getPosition().equals(enemy.getPosition().getRandomPosition()) || field.getPlayer1().getPosition().equals(enemy.getPosition()) || field.getPlayer2().getPosition().equals(enemy.getPosition())){
                System.exit(0);
            }
        }
    }

    private void movePlayer(Player player, Position position) {
        if (canPlayerMove(position)) {
            player.setPosition(position);
            for(Enemy enemy: field.getEnemies()){
                if(enemy.getPosition().equals(position)){
                    System.exit(0);
                }
            }
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


}