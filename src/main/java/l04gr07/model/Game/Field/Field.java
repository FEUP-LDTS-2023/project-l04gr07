package l04gr07.model.Game.Field;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.*;
import l04gr07.model.Game.FieldElements.PlayerState.PlayerState;
import l04gr07.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Field {
    private int height;
    private int width;
    private Position position;
    private TextGraphics graphics;
    private PlayerState playerState;
    private List<Player> players;
    //private Player1 player1 = new Player1(10, 10);
    //private Player2 player2 = new Player2(15, 15);
    private List<Wall> walls =new ArrayList<>();
    private List<Fruit> fruits =new ArrayList<>();
    private IceCube iceCube;


    public Field(int width, int height) {
        this.height = height;
        this.width = width;
    }
    public Field(int width, int height,PlayerState playerState) throws IOException, URISyntaxException, FontFormatException {
        this.height = height;
        this.width = width;
        this.playerState = playerState;
        playerState.initializing();
        this.players = playerState.getModel();
    }

    public IceCube getIceCube(){return iceCube;}
    public void setIceCube(IceCube iceCube){this.iceCube = iceCube;}
    public List<Wall> getWalls(){return walls;}
    public List<Fruit> getFruits(){return fruits;}

    public TextGraphics getGraphics(){return graphics;}

    public void setPosition(Position positionn) {
        position=positionn;
    }

    /*
    public Player_ getPlayer1() {
        return player1;
    }
    public Player_ getPlayer2() {
        return player2;
    }

     */
    public Player getPlayer1() {
        return players.get(0);
    }
    public Player getPlayer2() {
        return players.get(1);
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public PlayerState getPlayerState(){return playerState;}
    public void setPlayerState(PlayerState playerState){this.playerState = playerState;}

}

