package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Position;

public class MediumDifficulty implements DifficultyStrategy{
    @Override
    public Field createField() {
        Position player1Pos = new Position(4,3);
        Position player2Pos = new Position(4,20);
        ReadMap readMap = new ReadMap("mediumMap.txt", 400, player1Pos, player2Pos);
        Field field = readMap.processMap();
        field.setIceCube(new IceCube(2,2));
        return field;
    }
}
