package model;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Position> body = new LinkedList<>();
    private boolean isAlive = true;

    public Snake(Position start,int bodyLength) {
        for (int i = 0; i < bodyLength; i++) {
            body.add(new Position(start.row, start.col - i));
        }
    }
    public Position head() {
        return body.getFirst();
    }

    public boolean contains(Position p) {
        return body.contains(p);
    }

    public void grow(Position newHead) {
        body.addFirst(newHead);
    }

    public void move(Position newHead) {
        body.addFirst(newHead);
        body.removeLast();
    }

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public LinkedList<Position> getBody() {
        return body;
    }
}
