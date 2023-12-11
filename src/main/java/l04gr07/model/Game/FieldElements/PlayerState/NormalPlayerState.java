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

public class NormalPlayerState extends PlayerState{
    private List<PlayerViewer> playerViewers =new ArrayList<>();
    private List<Player> playerModels =new ArrayList<>();

    private List<PlayerController> playerControllers  =new ArrayList<>();

    private Position player1Pos;
    private Position player2Pos;

    public NormalPlayerState(Position player1Pos, Position player2Pos) {
        super();
        this.player1Pos =  player1Pos;
        this.player2Pos =  player2Pos;

    }

    @Override
    public List<PlayerViewer> getViewer() {
        return playerViewers;
    }

    @Override
    public List<PlayerController> getControl() {
        return playerControllers;
    }

    @Override
    public List<Player> getModel() {
        System.out.println("Got Normal State players");
        return playerModels;
    }



    @Override
    public void initializing() throws IOException, URISyntaxException, FontFormatException {
        System.out.println("NormalIceCream state");
        Player player1 = new Player(player1Pos.getx(),player1Pos.gety());
        Player player2 = new Player(player2Pos.getx(),player2Pos.gety());
        playerModels.add(player1);
        playerModels.add(player2);
    }
}
