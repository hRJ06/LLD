package Snake;

import Snake.ConcreteGame.SnakeGame;
import Snake.FoodItemFactory.FoodItem;
import Snake.FoodItemFactory.FoodItemFactory;
import Snake.MovementStrategyPattern.ConcreteStrategy.HumanMovementStrategy;
import Snake.MovementStrategyPattern.MovementStrategy;
import Snake.ObserverPattern.ConcreteObserver.ConsoleGameObserver;
import Snake.ObserverPattern.GameObserver;

import static Snake.Constant.*;

public class Main {
    public static void main(String[] args) {
        int width = 20, height = 15;
        FoodItem[] foodPositions = {
                FoodItemFactory.createFood(new int[]{0, 1}, BONUS),
                FoodItemFactory.createFood(new int[]{10, 8}, NORMAL),
                FoodItemFactory.createFood(new int[]{3, 12}, BONUS),
                FoodItemFactory.createFood(new int[]{8, 17}, NORMAL),
                FoodItemFactory.createFood(new int[]{12, 3}, NORMAL)
        };
        MovementStrategy strategy = new HumanMovementStrategy();
        GameObserver observer = new ConsoleGameObserver();

        SnakeGame game = new SnakeGame(strategy, width, height, foodPositions);
        game.addObserver(observer);

        game.play();
    }
}
