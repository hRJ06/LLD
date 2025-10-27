package Chess.PieceFactory;

import Chess.Board;
import Chess.Cell;
import Chess.MovementStrategyPattern.MovementStrategy;

public abstract class Piece {
    private final boolean isWhitePiece;
    private boolean isKilled = false;
    private final MovementStrategy strategy;

    public Piece(MovementStrategy strategy, boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
        this.strategy = strategy;
    }

    public boolean isWhitePiece() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return strategy.canMove(board, startCell, endCell);
    }
}
