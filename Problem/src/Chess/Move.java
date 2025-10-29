package Chess;

import java.util.Objects;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public Boolean isValid() {
        if(Objects.isNull(endCell.getPiece())) return true;
        else return startCell.getPiece().isWhitePiece() != endCell.getPiece().isWhitePiece();
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }
}
