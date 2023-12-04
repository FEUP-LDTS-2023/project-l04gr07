package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public class IceShot extends Element{
    private String direction;
    public IceShot(int x, int y,String direction) {
        super(x, y);
        this.direction=direction;
    }
    public Position getPosition() {
        return position;
    }
    public String getDirection(){return direction;}
}
