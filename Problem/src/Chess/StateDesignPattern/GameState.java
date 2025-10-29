package Chess.StateDesignPattern;

public interface GameState {
    void next(GameContext context, boolean hasWon);
    boolean isGameOver();
}
