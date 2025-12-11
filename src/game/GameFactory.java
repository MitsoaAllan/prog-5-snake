package game;

import model.*;
import java.util.Random;

public class GameFactory {

    public static Game createDefaultGame() {
        int width = 40;
        int height = 20;

        Snake snake = new Snake(new Position(10, 10), 3);

        Random rnd = new Random();
        Food food = new Food(
                new Position(rnd.nextInt(height - 2) + 1, rnd.nextInt(width - 2) + 1)
        );

        return new Game(width, height, snake, food);
    }
}

