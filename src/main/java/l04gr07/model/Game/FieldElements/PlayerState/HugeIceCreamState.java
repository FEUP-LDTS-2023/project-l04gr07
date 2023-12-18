package l04gr07.model.Game.FieldElements.PlayerState;

import l04gr07.control.PlayerController;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.PlayerViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HugeIceCreamState extends PlayerState{
    private Position position;
    private List<PlayerViewer> playerViewer =new ArrayList<>();
    private List<Player> playerModel =new ArrayList<>();

    private List<PlayerController> playerController  =new ArrayList<>();
    @Override
    public List<PlayerViewer> getViewer() {
        return playerViewer;
    }

    @Override
    public List<PlayerController> getControl() {
        return playerController;
    }

    public HugeIceCreamState(Position position){this.position = position;}

    @Override
    public List<Player> getModel() {
        return playerModel;
    }


    @Override
    public void initializing() throws IOException, URISyntaxException, FontFormatException {
        Player player = new Player(position.getx(), position.gety());
        playerModel.add(player);

    }
}
