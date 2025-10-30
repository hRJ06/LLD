package Snake.MovementStrategyPattern;

import Snake.Position;

public interface MovementStrategy {
    Position makeMove(Position currentHead, String direction);
}
