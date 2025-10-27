package Chess.PieceFactory.ConcretePiece;

import Chess.MovementStrategyPattern.ConcreteMovementStrategy.QueenMovementStrategy;
import Chess.PieceFactory.Piece;

public class Queen extends Piece {

    public Queen(boolean isWhitePiece) {
        super(new QueenMovementStrategy(), isWhitePiece);
    }
}
