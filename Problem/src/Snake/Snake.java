package Snake;

import Chess.Move;
import Snake.MovementStrategyPattern.MovementStrategy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Snake {
    public final Deque<Position> body;
    public final Map<Position, Boolean> positionMap;
    private final MovementStrategy strategy;

    public Snake(MovementStrategy strategy) {
        this.body = new LinkedList<>();
        this.positionMap = new HashMap<>();
        this.strategy = strategy;

        Position initial = new Position(0, 0);
        body.offerFirst(initial);
        positionMap.put(initial, true);
    }

    public MovementStrategy getStrategy() {
        return strategy;
    }
}
