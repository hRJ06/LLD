package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.KingMovementStrategy;
import Chess.PieceFactory.Piece;

public class King extends Piece {
    public King(boolean isWhitePiece) {
        super(new KingMovementStrategy(), isWhitePiece);
    }
}
