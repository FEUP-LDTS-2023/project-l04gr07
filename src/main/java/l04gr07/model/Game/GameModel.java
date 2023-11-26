package l04gr07.model.Game;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Model;

import java.io.IOException;
import java.util.List;

public class GameModel implements Model {
    private Field field;

    public GameModel(String file)  throws IOException {
        ReadMap readMap = new ReadMap("easyMap.txt");
        field = readMap.processMap();
    }

    public Field getField() {
        return field;
    }
}
