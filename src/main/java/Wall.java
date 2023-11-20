import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int x, int y){
        super(x,y);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position positionn) {
        position=positionn;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2f578c"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#2f578c"));
        graphics.putString(new TerminalPosition(position.getx(), position.gety()), "M");
    }
}
