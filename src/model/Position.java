package model;

import java.util.Objects;

public class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position move(Direction d){
        return switch (d){
            case DOWN -> new Position(row + 1, col);
            case UP -> new Position(row - 1, col);
            case LEFT -> new Position(row , col - 1);
            case RIGHT -> new Position(row , col + 1);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
