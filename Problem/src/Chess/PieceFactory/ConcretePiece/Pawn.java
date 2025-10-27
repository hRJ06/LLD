package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.PawnMovementStrategy;
import Chess.PieceFactory.Piece;

public class Pawn extends Piece {
    public Pawn(boolean isWhitePiece) {
        super(new PawnMovementStrategy(), isWhitePiece);
    }
}
