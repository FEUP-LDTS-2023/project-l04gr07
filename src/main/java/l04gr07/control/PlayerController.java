package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;

import static java.lang.System.exit;

public class PlayerController implements Control{

    private Field field;
    private Boolean isHugeIceCream = false;

    public PlayerController(Field field){this.field = field;}


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
    @Override
    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {

            case ArrowUp: {
                if (!isHugeIceCream){
                movePlayer(field.getPlayer2(), field.getPlayer2().moveUp());}break;}
                //else : shoot up
            case ArrowDown: {
                if (!isHugeIceCream){
                movePlayer(field.getPlayer2(), field.getPlayer2().moveDown());}break;}
                //else : shoot down
            case ArrowLeft: {
                if (!isHugeIceCream){
                movePlayer(field.getPlayer2(), field.getPlayer2().moveLeft());}break;}
                //else : shoot left
            case ArrowRight: {
                if (!isHugeIceCream){
                movePlayer(field.getPlayer2(), field.getPlayer2().moveRight());}break;}
                //else : shoot right

            case Character: {
                char character = key.getCharacter();
                switch (character) {
                    case 'W':
                    case 'w': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveUp());break;}
                    case 'S':
                    case 's': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveDown());break;}
                    case 'A':
                    case 'a': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveLeft());break;}
                    case 'D':
                    case 'd': {
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveRight());break;}
                    case 'Q':
                    case 'q': {
                        exit(0);break;}
                }
                break;
            }

        }

    }

    public void setHugeIceCream(boolean b) {
        isHugeIceCream = b;
    }


}
