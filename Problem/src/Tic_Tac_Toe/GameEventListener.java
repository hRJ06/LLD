package Tic_Tac_Toe;

public interface GameEventListener {
    void onMoveMade(Position position, Symbol symbol);
    void onGameStateChanged(GameState state);
}
