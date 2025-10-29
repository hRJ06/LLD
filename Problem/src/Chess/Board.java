package Chess;

import Chess.PieceFactory.PieceFactory;

import java.util.Objects;

public class Board {
    private static Board instance;
    private Cell[][] board;

    private Board(int row) {
        initialize(row);
    }

    public static Board getInstance(int row) {
        if(Objects.isNull(instance)) {
            instance = new Board(row);
        }
        return instance;
    }

    private void initialize(int row) {
        this.board = new Cell[row][row];

        /* WHITE */
        setPieceRow(0, true);
        setPawnRow(0, row, true);

        /* BLACK */
        setPieceRow(row - 1, false);
        setPawnRow(row - 2, row, false);

        /* EMPTY */
        for(int i = 2; i<row - 2; i++) {
            for(int j = 0; j<row; j++) {
                board[i][j] = new Cell(i, j, null);
            }
        }
    }

    public Cell getCell(int row, int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return board[row][col];
        }
        return null;
    }

    private void setPieceRow(int row, boolean isWhite) {
        board[row][0] = new Cell(row, 0, PieceFactory.createPiece("rook", isWhite));
        board[row][1] = new Cell(row, 1, PieceFactory.createPiece("knight", isWhite));
        board[row][2] = new Cell(row, 2, PieceFactory.createPiece("bishop", isWhite));
        board[row][3] = new Cell(row, 3, PieceFactory.createPiece("queen", isWhite));
        board[row][4] = new Cell(row, 4, PieceFactory.createPiece("king", isWhite));
        board[row][5] = new Cell(row, 5, PieceFactory.createPiece("bishop", isWhite));
        board[row][6] = new Cell(row, 6, PieceFactory.createPiece("knight", isWhite));
        board[row][7] = new Cell(row, 7, PieceFactory.createPiece("rook", isWhite));
    }

    private void setPawnRow(int row, int cols, boolean isWhite) {
        for(int col = 0; col<cols; col++) {
            board[row][col] = new Cell(row, col, PieceFactory.createPiece("pawn", isWhite));
        }
    }
}
