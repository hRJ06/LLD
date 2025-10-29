package Chess.StateDesignPattern.ConcreteGameState;

import Chess.StateDesignPattern.GameContext;
import Chess.StateDesignPattern.GameState;

public class WhiteWonState implements GameState {
    @Override
    public void next(GameContext context, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
