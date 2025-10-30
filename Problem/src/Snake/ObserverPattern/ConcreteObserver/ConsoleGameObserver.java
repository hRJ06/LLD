package Snake.ObserverPattern.ConcreteObserver;

import Snake.ObserverPattern.GameObserver;
import Snake.Position;

public class ConsoleGameObserver implements GameObserver {
    @Override
    public void onMoveMade(Position newHeadPosition) {
        System.out.println("Snake moved to position: [" + newHeadPosition.getRow() + ", " + newHeadPosition.getCol() + "]");
    }

    @Override
    public void onGameOver(int finalScore) {
        System.out.println("Game Over! Final score - " + finalScore);
    }
}
