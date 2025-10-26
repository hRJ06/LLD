package Tic_Tac_Toe;

public class Player {
    Symbol symbol;
    PlayerStrategy strategy;

    public Player(Symbol symbol, PlayerStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public PlayerStrategy getStrategy() {
        return strategy;
    }
    public Symbol getSymbol() {
        return symbol;
    }

}
