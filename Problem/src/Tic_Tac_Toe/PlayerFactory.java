package Tic_Tac_Toe;

public interface PlayerFactory {
    Player createPlayer(Symbol symbol, PlayerStrategy strategy);
}
