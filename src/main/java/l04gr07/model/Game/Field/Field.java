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
    private List<Wall> walls =new ArrayList<>();
    private List<Fruit> fruits =new ArrayList<>();
    private List<Enemy> enemies=new ArrayList<>();
    private IceCube iceCube;
    private long speed;
    private IceShot iceshot= new IceShot(-1,-1, "NO");

    public Field(int width, int height) {
        this.height = height;
        this.width = width;
    }
    public Field(int width, int height,PlayerState playerState, long speed) throws IOException, URISyntaxException, FontFormatException {
        this.height = height;
        this.width = width;
        this.speed=speed;
        this.playerState = playerState;
        playerState.initializing();
        this.players = playerState.getModel();
    }

    public IceCube getIceCube(){return iceCube;}
    public long getSpeed(){return speed;}
    public void setIceCube(IceCube iceCube){this.iceCube = iceCube;}
    public void setPlayers(List<Player> players){
        this.players = players;}
    public List<Wall> getWalls(){return walls;}
    public void setWalls(List<Wall> walls){this.walls = walls;}

    public List<Fruit> getFruits(){return fruits;}
    public List<Enemy> getEnemies(){return enemies;}
    public IceShot getIceShot() {
        return iceshot;
    }

    public void setIceshot(IceShot iceshot) {
        this.iceshot = iceshot;
    }

    public Player getPlayer1() {
        return players.get(0);
    }
    public Player getPlayer2() {
        if(players.size()==2) return players.get(1);
        else return null;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public PlayerState getPlayerState(){
        return playerState;}
    public void setPlayerState(PlayerState playerState){
        this.playerState = playerState;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isPlayer(Position position) {
        for (Player player : players)
            if (player.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isFruit(Position position) {
        for (Fruit fruit:fruits)
            if (fruit.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isIceCube(Position position) {
            if (iceCube.getPosition().equals(position))
                return true;
        return false;
    }

    public Enemy isMonster(Position position) {
        for (Enemy monster : enemies)
            if (monster.getPosition().equals(position))
                return monster;
        return null;
    }

    public void setFruit(List<Fruit> fruit) {
        this.fruits=fruit;
    }

    public void setEnemy(List<Enemy> enemies) {
        this.enemies=enemies;
    }
}