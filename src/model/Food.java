package model;

public class Food {
    private Position position;
    private boolean eaten = false;

    public Food(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void consume() {
        eaten = true;
    }

    public boolean isEaten() {
        return eaten;
    }
}
