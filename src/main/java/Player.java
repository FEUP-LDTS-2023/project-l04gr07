import com.googlecode.lanterna.graphics.TextGraphics;

public interface Player {

    public abstract void setPosition(Position positionn);
    public abstract Position moveUp();
    public abstract Position moveDown();
    public abstract Position moveLeft();
    public abstract Position moveRight();
    public abstract void draw(TextGraphics graphics);

}
