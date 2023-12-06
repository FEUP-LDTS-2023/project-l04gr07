package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public class Player extends Element {

    public String lastDirection = "";
    public Player(int x, int y){super(x,y);}
    public void setPosition(Position positionn) {
        position=positionn;
    }
    public Position moveUp(){
        return new Position(position.getx(), position.gety()-1);}
    public Position moveDown(){
        return new Position(position.getx(), position.gety()+1);}
    public Position moveLeft(){
        return new Position(position.getx()-1, position.gety());}
    public Position moveRight(){
        return new Position(position.getx()+1, position.gety());}

    public Position getPosition(){return position;}
    public String getLastDirection(){return lastDirection;}
    public void setLastDirection(String lastDirection){this.lastDirection = lastDirection;}

}
