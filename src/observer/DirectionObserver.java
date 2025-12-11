package observer;

import model.Direction;

public interface DirectionObserver {
    void onDirectionChanged(Direction d);
}
