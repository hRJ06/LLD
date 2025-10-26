package Tic_Tac_Toe;

public class GameContext {
    private GameState state;

    public GameContext() {
        this.state = new XTurnState();
    }

    public GameState getState() {
        return state;
    }
    public void setState(GameState state) {
        this.state = state;
    }

    public void next(boolean hasWon) {
        state.next(this, hasWon);
    }
    public boolean isGameOver() {
        return state.isGameOver();
    }
}
