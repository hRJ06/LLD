package Tic_Tac_Toe;

public class XWonState implements GameState{
    @Override
    public void next(GameContext context, boolean hasWon) {
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
