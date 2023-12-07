package l04gr07.model;

import l04gr07.model.Game.FieldElements.IceCube;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCubeTest {
    @Test
    public void iceCubePosition(){
        IceCube iceCube = new IceCube(3, 4);
        assertEquals(iceCube.getPosition().getx(), 3);
        assertEquals(iceCube.getposition().gety(), 4);
    }
}
