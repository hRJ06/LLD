package Tic_Tac_Toe;

import java.util.Objects;

public class Board {
    private final int row;
    private final int col;
    private final Symbol[][] grid;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        grid = new Symbol[row][col];
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X -> System.out.print(" X ");
                    case O -> System.out.print(" O ");
                    case EMPTY -> System.out.print("   ");
                    default -> System.out.print(" . ");
                }
                if(j < col - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < row - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public boolean isValidMove(Position pos) {
        return pos.row >= 0 && pos.row < row && pos.col >= 0 && pos.col < col && Objects.equals(grid[pos.row][pos.col], Symbol.EMPTY);
    }

    public void makeMove(Position move, Symbol symbol) {
        grid[move.row][move.col] = symbol;
    }

    public void checkGameState(GameContext context) {
        for(int i = 0; i<row; i++) {
            if(grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.next(true);
                return;
            }
        }

        for(int j = 0; j<col; j++) {
            Symbol[] column = new Symbol[col];
            for(int i = 0; i<row; i++) {
                column[i] = grid[i][j];
            }
            if(column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.next(true);
                return;
            }
        }

        Symbol[] diagonal1 = new Symbol[Math.min(row, col)];
        Symbol[] diagonal2 = new Symbol[Math.min(row, col)];
        for(int i = 0; i<Math.min(row, col); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][col - i - 1];
        }
        if(diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.next(true);
            return;
        }
        if(diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.next(true);
        }
    }


    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for(Symbol s : line) {
            if(s != first) {
                return false;
            }
        }
        return true;
    }
}
