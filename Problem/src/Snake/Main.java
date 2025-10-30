package Snake;

import Snake.ConcreteGame.SnakeGame;
import Snake.MovementStrategyPattern.ConcreteStrategy.HumanMovementStrategy;
import Snake.MovementStrategyPattern.MovementStrategy;
import Snake.ObserverPattern.ConcreteObserver.ConsoleGameObserver;
import Snake.ObserverPattern.GameObserver;

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
        GameObserver observer = new ConsoleGameObserver();

        SnakeGame game = new SnakeGame(strategy, width, height, foodPositions);
        game.addObserver(observer);

        game.play();
    }
}
