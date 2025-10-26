package Tic_Tac_Toe;

public class OTurnState implements GameState{
    @Override
    public void next(GameContext context, boolean hasWon) {
        if(hasWon) {
            context.setState(new OWonState());
        }
        else {
            context.setState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
