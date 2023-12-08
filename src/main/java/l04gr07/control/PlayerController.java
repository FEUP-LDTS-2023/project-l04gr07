package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Position;
import l04gr07.states.GameOverState;
import l04gr07.states.GameState;
import l04gr07.states.InstructionState;
import l04gr07.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class PlayerController extends Controller implements Control{
    private final GameModel gameModel;
    private GameState gameState;
    private Field field;
    private long lastMovement=0;
    private Boolean isHugeIceCream = false;

    private GameController gameController;
    public PlayerController(Field field, GameController gameController){
        this.field = field;
        this.gameController=gameController;
        this.gameModel = this.gameController.getGameState().getModel();

/*
    public PlayerController(Field field, GameModel gameModel, GameState gameState){
        this.field = field;
        this.gameModel=gameModel;
        this.gameState=gameState;
        */

    }
   /* public void MoveUp(){
        for (IceShot iceShot: field.getIceShot()) {
            System.out.println("oi");
            gameController.randomIceShot(currentTimeMillis());
            }
    }*/


    public boolean canPlayerMove(Position position) throws IOException, URISyntaxException, FontFormatException {
        if ((position.getx() < 0) || (position.getx() > field.getWidth() - 1)) return false;
        if ((position.gety() > field.getHeight() - 1) || (position.gety() < 0)) return false;
        for (Wall wall : field.getWalls()) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        for(Enemy enemy: field.getEnemies()){
            if(enemy.getPosition().equals(position)){
                gameState.getGUI().close(); gameState.stopRunning();setControllerState(new GameOverState());
            }
        }
        return true;
    }


    private void movePlayer(Player player, Position position) throws IOException, URISyntaxException, FontFormatException {
        if (canPlayerMove(position)) {
            player.setPosition(position);
        }
        for(Enemy enemy: field.getEnemies()){
            if(enemy.getPosition().equals(position)){
                gameState.getGUI().close(); gameState.stopRunning();setControllerState(new GameOverState());
            }
        }
    }

    private void iceWall(Player player){

        Position playerPos = player.getPosition();
        Boolean create = createWalls(player);
        if(create){createWalls(player);}

        for(Wall wall : field.getWalls()){
            Position wallPos = wall.getPosition();
            switch(player.getLastDirection()) {
                case "UP" : {
                    if((wallPos.getx() ==playerPos.getx())&& (wallPos.gety() == playerPos.gety()-1) && !create){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "DOWN" : {
                    if((wallPos.getx() == playerPos.getx())&& (wallPos.gety() == playerPos.gety()+1) && !create){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "LEFT" : {
                    if((wallPos.getx() == playerPos.getx()-1)&& (wallPos.gety() == playerPos.gety()) && !create){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "RIGHT" : {
                    if((wallPos.getx() == playerPos.getx()+1)&& (wallPos.gety() == playerPos.gety())&& !create){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }


            }
        }
    }

    private Boolean createWalls(Player player){
        String direction = player.getLastDirection();
        Position playerPos = player.getPosition();
        switch(direction){
            case "UP" : {
                Position wallPos = new Position(playerPos.getx(),playerPos.gety()-1);
                if(field.isEmpty(wallPos) && !field.isPlayer(wallPos)){
                    int x = wallPos.getx();
                    int y = wallPos.gety();
                    while(field.isEmpty(wallPos) && y >= 0){
                       // System.out.println("CREATED WALLS");
                        Wall wall = new Wall(x ,y);
                        y--;
                        wallPos = new Position(x,y);
                        field.getWalls().add(wall);}
                    return true;
                }
                break;
            }
            case "DOWN" : {
                System.out.println("CREATED WALLS");
                Position wallPos = new Position(playerPos.getx(),playerPos.gety()+1);
                if(field.isEmpty(wallPos) && !field.isPlayer(wallPos)){
                    int x = wallPos.getx();
                    int y = wallPos.gety();
                    while(field.isEmpty(wallPos) && y <= field.getHeight()){
                        Wall wall = new Wall(x ,y);
                        y++;
                        wallPos = new Position(x,y);
                        field.getWalls().add(wall);}
                    return true;
                }
                break;
            }
            case "LEFT" : {
                Position wallPos = new Position(playerPos.getx()-1,playerPos.gety());
                if(field.isEmpty(wallPos)&& !field.isPlayer(wallPos)){
                    int x = wallPos.getx();
                    int y = wallPos.gety();
                    while(field.isEmpty(wallPos) && x >= 0){
                        System.out.println("CREATED WALLS");
                        Wall wall = new Wall(x ,y);
                        x--;
                        wallPos = new Position(x,y);
                        field.getWalls().add(wall);}
                    return true;
                }
                break;
            }
            case "RIGHT" : {
                Position wallPos = new Position(playerPos.getx()+1,playerPos.gety());
                if(field.isEmpty(wallPos)&& !field.isPlayer(wallPos)){
                    int x = wallPos.getx();
                    int y = wallPos.gety();
                    while(field.isEmpty(wallPos) && x <= field.getWidth()){
                        System.out.println("CREATED WALLS");
                        Wall wall = new Wall(x ,y);
                        x++;
                        wallPos = new Position(x,y);
                        field.getWalls().add(wall);}
                    return true;
                }
                break;
            }
        }
        return false;
    }




    private void breakWalls(Wall wall, String direction){
        Position wallPos = wall.getPosition();
        List<Wall> wallsThatDontBreak = new ArrayList<>();

        for(Wall wall1 : field.getWalls()){
            Boolean hasNeighbour= false;
            Position wall1Pos = wall1.getPosition();
            switch(direction) {
                case "UP" : {
                    if((wall1Pos.getx() == wallPos.getx()) &&(wall1Pos.gety() <= wallPos.gety())){
                        if(wall1Pos == wallPos){continue;}
                        for(Wall possibleWallNeighbour : field.getWalls()){
                            Position WallNeighPos = possibleWallNeighbour.getPosition();
                            if((WallNeighPos.gety()-wall1Pos.gety() == 1) &&(WallNeighPos.getx() == wall1Pos.getx())){
                                hasNeighbour = true;
                                break;
                            }
                        }
                        if(hasNeighbour) continue;
                    }
                    break;
                }
                case "DOWN" : {
                    if((wall1Pos.getx() == wallPos.getx()) &&(wall1Pos.gety() >= wallPos.gety())){
                        if(wall1Pos == wallPos){continue;}
                        for(Wall possibleWallNeighbour : field.getWalls()){
                            Position WallNeighPos = possibleWallNeighbour.getPosition();
                            if((wall1Pos.gety()-WallNeighPos.gety() == 1) &&(WallNeighPos.getx() == wall1Pos.getx())){
                                hasNeighbour = true;
                                break;
                            }
                        }
                        if(hasNeighbour) continue;
                    }
                    break;
                }
                case "LEFT" : {
                    if((wall1Pos.getx() <= wallPos.getx()) &&(wall1Pos.gety() == wallPos.gety())){
                        if(wall1Pos == wallPos){continue;}
                        for(Wall possibleWallNeighbour : field.getWalls()){
                            Position WallNeighPos = possibleWallNeighbour.getPosition();
                            if((wall1Pos.gety() == WallNeighPos.gety()) &&(WallNeighPos.getx() - wall1Pos.getx() == 1)){
                                hasNeighbour = true;
                                break;
                            }
                        }
                        if(hasNeighbour) continue;
                    }
                    break;
                }
                case "RIGHT" : {
                    if((wall1Pos.getx() >= wallPos.getx()) &&(wall1Pos.gety() == wallPos.gety())){
                        if(wall1Pos == wallPos){continue;}
                        for(Wall possibleWallNeighbour : field.getWalls()){
                            Position WallNeighPos = possibleWallNeighbour.getPosition();
                            if((wall1Pos.gety() == WallNeighPos.gety()) &&(wall1Pos.getx() - WallNeighPos.getx() == 1)){
                                hasNeighbour = true;
                                break;
                            }
                        }
                        if(hasNeighbour) continue;
                    }
                    break;
                }
            }
            wallsThatDontBreak.add(wall1);
        }
        field.setWalls(wallsThatDontBreak) ;
    }


    @Override
    public void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        switch (key.getKeyType()) {
            case Enter:{
                if (!isHugeIceCream){iceWall(field.getPlayer2());break;}
                else{iceWall(field.getPlayer1());}
            break;}

            case ArrowUp: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("UP");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveUp());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx(), field.getPlayer1().getPosition().gety()-1,"UP");
                   // field.getIceShot().add(iceshot);
                    field.setIceshot(iceshot);
                    //System.out.println("upi");
                   //gameController.randomIceShot("UP");
                }
                break;}
            case ArrowDown: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("DOWN");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveDown());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx(), field.getPlayer1().getPosition().gety()+1,"DOWN");
                   // field.getIceShot().add(iceshot);
                    field.setIceshot(iceshot);
                    //iceshot.MoveDown();
                }
                break;}
            //else : shoot down
            case ArrowLeft: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("LEFT");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveLeft());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx()-1, field.getPlayer1().getPosition().gety(),"LEFT");
                    //field.getIceShot().add(iceshot);
                    field.setIceshot(iceshot);
                    //iceshot.MoveLeft();
                }
                break;}
            //else : shoot left
            case ArrowRight: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("RIGHT");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveRight());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx()+1, field.getPlayer1().getPosition().gety(),"RIGHT");
                  //  field.getIceShot().add(iceshot);
                    field.setIceshot(iceshot);
                   // iceshot.MoveRight();
                }
                break;}
            //else : shoot right

            case Character: {
                char character = key.getCharacter();
                switch (character) {
                    case 'E':
                    case 'e': {
                        iceWall(field.getPlayer1());break;}
                    case 'W':
                    case 'w': {
                        field.getPlayer1().setLastDirection("UP");
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveUp());break;}
                    case 'S':
                    case 's': {
                        field.getPlayer1().setLastDirection("DOWN");
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveDown());break;}
                    case 'A':
                    case 'a': {
                        field.getPlayer1().setLastDirection("LEFT");
                        movePlayer(field.getPlayer1(), field.getPlayer1().moveLeft());break;}
                    case 'D':
                    case 'd': {
                        field.getPlayer1().setLastDirection("RIGHT");
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
