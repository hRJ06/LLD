package Tic_Tac_Toe;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X");
        PlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player O");
        PlayerFactory playerFactory = new SimplePlayerFactory();
        TicTacToeGame  game = new TicTacToeGame(playerXStrategy, playerOStrategy, playerFactory, 3, 3);
        GameEventListener listener = new ConsoleGameEventListener();
        game.addListener(listener);
        game.play();
    }
}
