package Tic_Tac_Toe;

public class TicTacToeGame implements BoardGame{
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final GameContext context;
    private Player currentPlayer;

    public TicTacToeGame(PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy, int row, int col) {
        this.board = new Board(row, col);
        this.playerX = new Player(Symbol.X, playerXStrategy);
        this.playerO = new Player(Symbol.O, playerOStrategy);
        this.context = new GameContext();
        this.currentPlayer = playerX;
    }

    @Override
    public void play() {
        do {
            board.printBoard();

            Position move = currentPlayer.getStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(context);
            switchPlayer();
        } while (!context.isGameOver());
        announceResult();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer != playerX) ? playerX : playerO;
    }

    private void announceResult() {
        GameState state = context.getState();
        if(state instanceof XWonState) {
            System.out.println("Player X won.");
        } else if(state instanceof OWonState) {
            System.out.println("Player O won.");
        } else {
            System.out.println("It's a draw.");
        }
    }
}
