package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public class Enemy extends Element{
    public Enemy(int x, int y) {
        super(x, y);
    }
    public Position getPosition() {
        return position;
    }
}
