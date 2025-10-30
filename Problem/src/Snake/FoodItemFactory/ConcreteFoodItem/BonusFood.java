package Snake.FoodItemFactory.ConcreteFoodItem;

import Snake.FoodItemFactory.FoodItem;

public class BonusFood extends FoodItem {
    public BonusFood(int row, int col) {
        super(row, col);
        this.points = 3;
    }
}
