package Chess.ConcreteGame;

import Chess.*;
import Chess.PieceFactory.ConcretePiece.King;
import Chess.PieceFactory.Piece;
import Chess.StateDesignPattern.ConcreteGameState.BlackWonState;
import Chess.StateDesignPattern.ConcreteGameState.WhiteWonState;
import Chess.StateDesignPattern.GameContext;
import Chess.StateDesignPattern.GameState;

import java.util.Objects;
import java.util.Scanner;

public class ChessGame implements BoardGame {
    private Board board;
    /* WHITE */
    private Player player1;
    /* BLACK */
    private Player player2;
    boolean isWhiteTurn;
    private GameContext context;

    public ChessGame(Player player1, Player player2) {
        this.board = Board.getInstance(8);
        this.player1 = player1;
        this.player2 = player2;
        this.isWhiteTurn = true;
        this.context = new GameContext();
    }
    /* TODO */
    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);
        while(!context.getState().isGameOver()) {
            Player currentPlayer = isWhiteTurn ? player1 : player2;
            System.out.println(currentPlayer.getName() + "'s turn (" + (currentPlayer.isWhitSide() ? "White" : "Black") + ")");

            System.out.println("Enter source row and column (e.g. 6 4): ");
            int startRow = sc.nextInt();
            int startCol = sc.nextInt();

            System.out.println("Enter destination row and column (e.g. 6 4): ");
            int endRow = sc.nextInt();
            int endCol = sc.nextInt();

            Cell startCell = board.getCell(startRow, startCol);
            Cell destCell = board.getCell(endRow, endCol);

            if(Objects.isNull(startCell) || Objects.isNull(startCell.getPiece())) {
                System.out.println("Invalid move. No piece at start cell.");
                continue;
            }

            if(Objects.isNull(destCell)) {
                System.out.println("Invalid move. Destination cell is invalid.");
                continue;
            }

            makeMove(new Move(startCell, destCell), currentPlayer);
        }
        announceResult();
    }

    private void makeMove(Move move, Player currentPlayer) {
        if(move.isValid()) {
            Piece sourcePiece = move.getStartCell().getPiece();
            if(sourcePiece.canMove(board, move.getStartCell(), move.getEndCell())) {
                Piece destinationPiece = move.getEndCell().getPiece();
                if(destinationPiece instanceof King) {
                    context.next(true);
                    return;
                }
                /* TODO - DRAW */
                destinationPiece.setKilled(true);
                move.getStartCell().setPiece(null);
                this.isWhiteTurn = !isWhiteTurn;
            }

        }
    }

    private void announceResult() {
        GameState state = context.getState();
        if(state instanceof WhiteWonState) {
            System.out.println("Player 1 won.");
        }
        else if(state instanceof BlackWonState) {
            System.out.println("Player 2 won.");
        }
        else {
            System.out.println("It's a draw.");
        }
    }
}
