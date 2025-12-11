package game;


import model.*;
import observer.*;
import ui.Renderer;
import java.util.Random;

public class Game implements DirectionObserver {

    private final int width;
    private final int height;
    private final Snake snake;
    private Food food;
    private GameState state = GameState.RUNNING;
    private Direction direction = Direction.RIGHT;

    private int score = 0;

    private final Renderer renderer = new Renderer();
    private final InputHandler inputHandler = new InputHandler(this);

    public Game(int width, int height, Snake s, Food f) {
        this.width = width;
        this.height = height;
        this.snake = s;
        this.food = f;
    }

    public void start() throws Exception {
        while (state == GameState.RUNNING) {

            inputHandler.listen();
            update();
            render();

            Thread.sleep(120);
        }
        System.out.println("GAME OVER – SCORE: " + score);
    }

    private void update() {
        Position newHead = snake.head().move(direction);

        // Wall collision
        if (newHead.row <= 0 || newHead.row >= height - 1 ||
                newHead.col <= 0 || newHead.col >= width - 1 ||
                snake.contains(newHead)) {

            snake.die();
            state = GameState.GAME_OVER;
            return;
        }

        // Food collision
        if (newHead.equals(food.getPosition())) {
            snake.grow(newHead);
            score++;
            respawnFood();
        } else {
            snake.move(newHead);
        }
    }

    private void respawnFood() {
        Random rnd = new Random();
        this.food = new Food(
                new Position(rnd.nextInt(height - 2) + 1, rnd.nextInt(width - 2) + 1)
        );
    }

    private void render() {
        renderer.render(width, height, snake, food, score);
    }

    @Override
    public void onDirectionChanged(Direction d) {
        // Prevent reversing direction directly
        if ((direction == Direction.UP && d == Direction.DOWN) ||
                (direction == Direction.DOWN && d == Direction.UP) ||
                (direction == Direction.LEFT && d == Direction.RIGHT) ||
                (direction == Direction.RIGHT && d == Direction.LEFT))
            return;

        this.direction = d;
    }

    public void changeDirection(Direction d) {
        onDirectionChanged(d);
    }
}

