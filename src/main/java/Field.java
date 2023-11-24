import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private int height;
    private int width;
    private Position position;
    private Player1 player1 = new Player1(10, 10);
    private Player2 player2 = new Player2(15, 15);
    private List<Wall> walls =new ArrayList<>();
    private List<Fruit> fruits =new ArrayList<>();

    public Field(int width, int height) {
        this.height = height;
        this.width = width;

    }


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player1.draw(graphics);
        player2.draw(graphics);
        ReadMap readMap = new ReadMap("easyMap.txt",graphics,walls,fruits);
        for(Wall wall :walls){wall.draw(graphics);}
        for(Fruit fruit: fruits){fruit.draw(graphics);}

    }
    public void setPosition(Position positionn) {
        position=positionn;
    }
    public boolean canPlayerMove(Position position){
        if ((position.getx()<0)||(position.getx()>width-1)) return false;
        if ((position.gety()>height-1)||(position.gety()<0)) return false;
        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) {
                return false;
            }
        return true;
    }

    private void movePlayer(Player player,Position position) {
        if (canPlayerMove(position)){
            player.setPosition(position);
        }
    }
    public void retrieveFruits() {
        for (Fruit fruit : fruits)
            if ((player1.getposition().equals(fruit.getposition())) || (player2.getposition().equals(fruit.getposition()))){
                fruits.remove(fruit);
                break;
            }
    }




    public void processKey(KeyStroke key) {
        switch (key.getKeyType()){
            case ArrowUp: {movePlayer(player2,player2.moveUp()); break;}
            case ArrowDown: {movePlayer(player2,player2.moveDown());; break;}
            case ArrowLeft: {movePlayer(player2,player2.moveLeft());; break;}
            case ArrowRight: {movePlayer(player2,player2.moveRight());; break;}

            case Character: {
                char character = key.getCharacter();
                switch (character) {
                    case 'W':
                    case 'w': {
                        movePlayer(player1,player1.moveUp());
                        break;
                    }
                    case 'S':
                    case 's': {
                        movePlayer(player1,player1.moveDown());
                        break;
                    }
                    case 'A':
                    case 'a': {
                        movePlayer(player1,player1.moveLeft());
                        break;
                    }
                    case 'D':
                    case 'd': {
                        movePlayer(player1,player1.moveRight());
                        break;
                    }
                }
                break;
            }

        }
        retrieveFruits();

    }
}

