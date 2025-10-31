package Snake.ObserverPattern;

import Snake.Position;

public interface GameObserver {
    void onMoveMade(Position newHeadPosition);
    void onGameOver(int finalScore);
    void onScoreUpdate(int newScore);
}
