import game.Game;
import game.GameFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = GameFactory.createDefaultGame();
        game.start();
    }
}