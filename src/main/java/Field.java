import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private int height;
    private int width;
    private Position position;
    private Player player = new Player(10, 10);
    private List<Wall> walls;
    private List<Fruit> fruits;

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        this.walls = createWalls();
        this.fruits =createFruits();
    }
    private List<Fruit> createFruits() {
        Random random = new Random();
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 7; i++)
            fruits.add(new Fruit(random.nextInt(width - 2) + 1, random.nextInt( height- 2) + 1));
        return fruits;
    }



    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        player.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Fruit fruit : fruits)
            fruit.draw(graphics);

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

    private void movePlayer(Position position) {
        if (canPlayerMove(position)){
            player.setPosition(position);
        }
    }
    public void retrieveFruits() {
        for (Fruit fruit : fruits)
            if (player.getposition().equals(fruit.getposition())){
                fruits.remove(fruit);
                break;
            }
    }



    public void processKey(KeyStroke key) {
        switch (key.getKeyType()){
            case ArrowUp: {movePlayer(player.moveup()); break;}
            case ArrowDown: {movePlayer(player.movedown()); break;}
            case ArrowLeft: {movePlayer(player.moveleft()); break;}
            case ArrowRight: {movePlayer(player.moveright()); break;}
        }
        retrieveFruits();
    }
}

