package observer;


import model.Direction;
import java.io.IOException;

public class InputHandler {

    private DirectionObserver observer;

    public InputHandler(DirectionObserver o) {
        this.observer = o;
    }

    public void listen() throws IOException {
        if (System.in.available() > 0) {
            char c = (char) System.in.read();
            switch (c) {
                case 'w' -> observer.onDirectionChanged(Direction.UP);
                case 's' -> observer.onDirectionChanged(Direction.DOWN);
                case 'a' -> observer.onDirectionChanged(Direction.LEFT);
                case 'd' -> observer.onDirectionChanged(Direction.RIGHT);
            }
        }
    }
}

