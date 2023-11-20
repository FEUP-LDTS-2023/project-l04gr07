import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element{
    public Player(int x, int y){
        super(x,y);
    }
    public void setPosition(Position positionn) {
        position=positionn;
    }
    public Position moveup(){
        return new Position(position.getx(), position.gety()-1);}
    public Position movedown(){
        return new Position(position.getx(), position.gety()+1);}
    public Position moveleft(){
        return new Position(position.getx()-1, position.gety());}
    public Position moveright(){
        return new Position(position.getx()+1, position.gety());}
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#c57d56"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "O");
    }
}
