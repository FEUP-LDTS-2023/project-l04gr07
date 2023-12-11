package l04gr07.model.Game.FieldElements.PlayerState;

import l04gr07.control.PlayerController;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.view.ElementsView.PlayerViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public abstract class PlayerState {
    public abstract List<PlayerViewer> getViewer();

    public abstract List<PlayerController> getControl();

    public abstract List<Player> getModel();

    public abstract void initializing() throws IOException, URISyntaxException, FontFormatException;

}
