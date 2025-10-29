package Chess.StateDesignPattern.ConcreteGameState;

import Chess.StateDesignPattern.GameContext;
import Chess.StateDesignPattern.GameState;

public class WhiteTurnState implements GameState {
    @Override
    public void next(GameContext context, boolean hasWon) {
        if(hasWon) {
            context.setState(new WhiteWonState());
        } else {
            context.setState(new BlackTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
