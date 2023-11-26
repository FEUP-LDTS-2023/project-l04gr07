package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public interface Player {

    public abstract void setPosition(Position positionn);
    public abstract Position moveUp();
    public abstract Position moveDown();
    public abstract Position moveLeft();
    public abstract Position moveRight();
    public abstract void draw(TextGraphics graphics);
    public Position getPosition();

}
