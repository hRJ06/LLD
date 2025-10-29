package Chess.StateDesignPattern;


import Chess.StateDesignPattern.ConcreteGameState.WhiteTurnState;

public class GameContext {
    private GameState state;

    public GameContext() {
        this.state = new WhiteTurnState();
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

}
