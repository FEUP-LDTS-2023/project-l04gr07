package l04gr07.model.Game.FieldElements;

import l04gr07.model.Position;

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
}
