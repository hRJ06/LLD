package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.RookMovementStrategy;
import Chess.PieceFactory.Piece;

public class Rook extends Piece {
    public Rook(boolean isWhitePiece) {
        super(new RookMovementStrategy(), isWhitePiece);
    }
}
