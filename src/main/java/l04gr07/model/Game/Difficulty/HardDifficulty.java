package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Position;

public class HardDifficulty implements DifficultyStrategy{
    @Override
    public Field createField() {
        Position player1Pos = new Position(5,6);
        Position player2Pos = new Position(7,6);
        ReadMap readMap = new ReadMap("hardMap.txt", 200, player1Pos, player2Pos);
        Field field = readMap.processMap();
        field.setIceCube(new IceCube(2,2));

        return field;
    }
}
