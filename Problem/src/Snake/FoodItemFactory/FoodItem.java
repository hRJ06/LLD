package Snake.FoodItemFactory;

public abstract class FoodItem {
    protected final int row;
    protected final int col;
    protected int points;

    public FoodItem(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getPoints() {
        return points;
    }
}
