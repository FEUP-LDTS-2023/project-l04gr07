package l04gr07.control;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;
import l04gr07.states.GameState;

import java.io.IOException;

import static java.lang.System.exit;


public class GameController implements Control {
    private Screen screen = null;
    private Field field = new Field(25, 25);
    private GameState gameState;
    protected Boolean spawnIceCube = false;


    public GameController(GameState gameState) {
        this.gameState = gameState;
        this.field = gameState.getModel().getField();
    }

    public boolean canPlayerMove(Position position) {
        if ((position.getx() < 0) || (position.getx() > field.getWidth() - 1)) return false;
        if ((position.gety() > field.getHeight() - 1) || (position.gety() < 0)) return false;
        for (Wall wall : field.getWalls())
            if (wall.getPosition().equals(position)) {
                return false;
            }
        return true;
    }


    private void movePlayer(Player player, Position position) {
        if (canPlayerMove(position)) {
            player.setPosition(position);
        }
    }

    public void retrieveFruits() {
        if(field.getFruits().size() == 0){spawnIceCube = true;notifyIceCubeObserver();}
        for (Fruit fruit : field.getFruits())
            if ((field.getPlayer1().getPosition().equals(fruit.getposition())) || (field.getPlayer2().getPosition().equals(fruit.getposition()))) {
                field.getFruits().remove(fruit);
                break;
            }
    }
    public void retrieveIceCube() {
            if ((field.getPlayer1().getPosition().equals(field.getIceCube().getposition())) || (field.getPlayer2().getPosition().equals(field.getIceCube().getposition()))) {
                spawnIceCube = false;notifyIceCubeObserver();
                field.setIceCube(null);
            }
    }
    public void notifyIceCubeObserver(){
        if(spawnIceCube){gameState.getViewer().spawnIceCube();}
        else gameState.getViewer().deSpawnIceCube(); }

    @Override
    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp: {
                movePlayer(field.getPlayer2(), field.getPlayer2().moveUp());
                break;
            }
            case ArrowDown: {
                movePlayer(field.getPlayer2(), field.getPlayer2().moveDown());
                ;
                break;
            }
            case ArrowLeft: {
                movePlayer(field.getPlayer2(), field.getPlayer2().moveLeft());
                ;
                break;
            }
            case ArrowRight: {
                movePlayer(field.getPlayer2(), field.getPlayer2().moveRight());
                ;
                break;
            }

            case Character: {
                char character = key.getCharacter();
                switch (character) {
                    case 'W':
                    case 'w': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveUp());
                        break;
                    }
                    case 'S':
                    case 's': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveDown());
                        break;
                    }
                    case 'A':
                    case 'a': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveLeft());
                        break;
                    }
                    case 'D':
                    case 'd': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveRight());
                        break;
                    }
                    case 'Q':
                    case 'q': {
                        exit(0);
                        break;
                    }
                }
                break;
            }

        }
        if(!spawnIceCube && field.getIceCube()!=null) retrieveFruits();
        if(spawnIceCube){retrieveIceCube();}
    }

}