package Chess.MovementStrategyPattern.ConcreteMovementStrategy;

import Chess.Board;
import Chess.Cell;
import Chess.MovementStrategyPattern.MovementStrategy;

public class RookMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return false;
    }
}
