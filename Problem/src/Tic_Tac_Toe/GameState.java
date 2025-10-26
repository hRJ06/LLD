package Tic_Tac_Toe;

public interface GameState {
    void next(GameContext context, boolean hasWon);
    boolean isGameOver();
}
