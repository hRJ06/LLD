package Chess.StateDesignPattern.ConcreteGameState;

import Chess.StateDesignPattern.GameContext;
import Chess.StateDesignPattern.GameState;

public class BlackWonState implements GameState {
    @Override
    public void next(GameContext context, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
