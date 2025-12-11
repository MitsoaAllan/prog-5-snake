package game.command;


import model.Direction;
import game.Game;

public class ChangeDirectionCommand implements Command {

    private final Game game;
    private final Direction newDir;

    public ChangeDirectionCommand(Game game, Direction d) {
        this.game = game;
        this.newDir = d;
    }

    @Override
    public void execute() {
        game.changeDirection(newDir);
    }
}

