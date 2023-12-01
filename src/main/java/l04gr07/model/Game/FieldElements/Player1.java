package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public class Player1 extends Element implements Player {


    public Player1(int x, int y){super(x,y);}
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
    /*
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#c57d56"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "O");
    }*/
}

