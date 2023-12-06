package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.IceCube;

public class HardDifficulty implements DifficultyStrategy{
    @Override
    public Field createField() {
        ReadMap readMap = new ReadMap("hardMap.txt", 200);
        Field field = readMap.processMap();
        field.setIceCube(new IceCube(2,2));

        return field;
    }
}
