package Chess;

public class Player {
    private final String name;
    private final boolean isWhitSide;

    public Player(String name, Boolean isWhitSide) {
        this.name = name;
        this.isWhitSide = isWhitSide;
    }

    public String getName() {
        return name;
    }

    public boolean isWhitSide() {
        return isWhitSide;
    }
}
