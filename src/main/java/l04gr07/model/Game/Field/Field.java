package l04gr07.model.Game.Field;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.FieldElements.*;
import l04gr07.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int height;
    private int width;
    private Position position;
    private TextGraphics graphics;
    private Player1 player1 = new Player1(10, 10);
    private Player2 player2 = new Player2(15, 15);
    private List<Wall> walls =new ArrayList<>();
    private List<Fruit> fruits =new ArrayList<>();
    private List<Enemy> enemies=new ArrayList<>();
    private IceCube iceCube;


    public Field(int width, int height) {
        this.height = height;
        this.width = width;

    }

    public IceCube getIceCube(){return iceCube;}
    public void setIceCube(IceCube iceCube){this.iceCube = iceCube;}
    public List<Wall> getWalls(){return walls;}
    public List<Fruit> getFruits(){return fruits;}
    public List<Enemy> getEnemies(){return enemies;}

    public TextGraphics getGraphics(){return graphics;}

    public void setPosition(Position positionn) {
        position=positionn;
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

}

