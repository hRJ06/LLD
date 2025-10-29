package Chess;

import Chess.ConcreteGame.ChessGame;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", true);
        Player player2 = new Player("Player2", false);
        ChessGame game = new ChessGame(player1, player2);
        game.play();
    }
}
