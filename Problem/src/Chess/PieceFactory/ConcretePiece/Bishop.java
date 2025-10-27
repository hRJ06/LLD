package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.BishopMovementStrategy;
import Chess.PieceFactory.Piece;

public class Bishop extends Piece {
    public Bishop(boolean isWhitePiece) {
        super(new BishopMovementStrategy(), isWhitePiece);
    }
}
