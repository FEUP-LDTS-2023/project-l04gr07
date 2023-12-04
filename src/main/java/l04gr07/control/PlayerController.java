package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class PlayerController implements Control{

    private Field field;

    private Boolean isHugeIceCream = false;

    public PlayerController(Field field){
        this.field = field;
    }


    public boolean canPlayerMove(Position position) {
        if ((position.getx() < 0) || (position.getx() > field.getWidth() - 1)) return false;
        if ((position.gety() > field.getHeight() - 1) || (position.gety() < 0)) return false;
        for (Wall wall : field.getWalls()) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        for(Enemy enemy: field.getEnemies()){
            if(enemy.getPosition().equals(position)){
                System.exit(0);
            }
        }
        return true;
    }


    private void movePlayer(Player player, Position position) {
        if (canPlayerMove(position)) {
            player.setPosition(position);
        }
        for(Enemy enemy: field.getEnemies()){
            if(enemy.getPosition().equals(position)){
                System.exit(0);
            }
        }
    }

    private void iceWall(Player player){
        Position playerPos = player.getPosition();
        for(Wall wall : field.getWalls()){
            Position wallPos = wall.getPosition();
            switch(player.getLastDirection()) {
                case "UP" : {
                    if((wallPos.getx() ==playerPos.getx())&& (wallPos.gety() == playerPos.gety()-1)){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "DOWN" : {
                    if((wallPos.getx() == playerPos.getx())&& (wallPos.gety() == playerPos.gety()+1)){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "LEFT" : {
                    if((wallPos.getx() == playerPos.getx()-1)&& (wallPos.gety() == playerPos.gety())){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }
                case "RIGHT" : {
                    if((wallPos.getx() == playerPos.getx()+1)&& (wallPos.gety() == playerPos.gety())){
                        breakWalls(wall,player.getLastDirection());
                    }
                    break;
                }


            }
        }
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
    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case Enter:{
                iceWall(field.getPlayer2());break;}

            case ArrowUp: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("UP");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveUp());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx(), field.getPlayer1().getPosition().gety()-1);
                    field.getIceShot().add(iceshot);
                }
                break;}
            case ArrowDown: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("DOWN");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveDown());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx(), field.getPlayer1().getPosition().gety()+1);
                    field.getIceShot().add(iceshot);
                }
                break;}
            //else : shoot down
            case ArrowLeft: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("LEFT");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveLeft());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx()-1, field.getPlayer1().getPosition().gety());
                    field.getIceShot().add(iceshot);
                }
                break;}
            //else : shoot left
            case ArrowRight: {
                if (!isHugeIceCream){
                    field.getPlayer2().setLastDirection("RIGHT");
                    movePlayer(field.getPlayer2(), field.getPlayer2().moveRight());}
                else {
                    IceShot iceshot = new IceShot(field.getPlayer1().getPosition().getx()+1, field.getPlayer1().getPosition().gety());
                    field.getIceShot().add(iceshot);
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
