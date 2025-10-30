package Snake.FoodItemFactory;

import Snake.FoodItemFactory.ConcreteFoodItem.BonusFood;
import Snake.FoodItemFactory.ConcreteFoodItem.NormalFood;

public class FoodItemFactory {
    public static FoodItem createFood(int[] position, String type) {
        if(type.equals("bonus")) {
            return new BonusFood(position[0], position[1]);
        }
        return new NormalFood(position[0], position[1]);
    }
}
