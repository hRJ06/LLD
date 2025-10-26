package Tic_Tac_Toe;

public class OWonState implements GameState{
    @Override
    public void next(GameContext context, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
