import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    public Element(int x, int y){
        this.position= new Position(x,y);
    }

    public Position getposition(){
        return position;
    }
    public void setposition(Position position){
        this.position=position;
    }
    public abstract void draw(TextGraphics graphics);
}
