import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Game game = new Game(55, 23);
        game.run();
    }
}