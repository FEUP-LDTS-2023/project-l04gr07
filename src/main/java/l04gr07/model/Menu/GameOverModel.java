package l04gr07.model.Menu;

import l04gr07.model.Model;

import java.util.Arrays;
import java.util.List;

public class GameOverModel implements Model {
    private final List<String> gameOverText;

    public GameOverModel(){
        this.gameOverText = Arrays.asList(
        "\t\tGame Over",
        "Press 'q' to exit"
        );
    }
    public List<String> getGameOverText() { return gameOverText; }
}
