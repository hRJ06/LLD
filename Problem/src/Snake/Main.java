package Snake;

import Snake.ConcreteGame.SnakeGame;
import Snake.MovementStrategyPattern.ConcreteStrategy.HumanMovementStrategy;
import Snake.MovementStrategyPattern.MovementStrategy;

public class Main {
    public static void main(String[] args) {
        int width = 20, height = 15;
        int[][] foodPositions = {
                {0, 1},
                {10, 8},
                {3, 12},
                {8, 17},
                {12, 3}
        };
        MovementStrategy strategy = new HumanMovementStrategy();
        SnakeGame game = new SnakeGame(strategy, width, height, foodPositions);
        game.play();
    }
}
