package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.KnightMovementStrategy;
import Chess.PieceFactory.Piece;

public class Knight extends Piece {
    public Knight(boolean isWhitePiece) {
        super(new KnightMovementStrategy(), isWhitePiece);
    }
}
