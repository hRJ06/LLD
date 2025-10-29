package Chess.StateDesignPattern.ConcreteGameState;

import Chess.StateDesignPattern.GameContext;
import Chess.StateDesignPattern.GameState;

public class BlackTurnState implements GameState {
    @Override
    public void next(GameContext context, boolean hasWon) {
        if(hasWon) {
            context.setState(new BlackWonState());
        } else {
            context.setState(new WhiteTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
