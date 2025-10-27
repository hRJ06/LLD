package Chess.MovementStrategyPattern;

import Chess.Board;
import Chess.Cell;

public interface MovementStrategy {
    boolean canMove(Board board, Cell startCell, Cell endCell);
}
