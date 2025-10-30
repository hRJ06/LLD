package Snake.MovementStrategyPattern.ConcreteStrategy;

import Snake.MovementStrategyPattern.MovementStrategy;
import Snake.Position;

public class HumanMovementStrategy implements MovementStrategy {
    @Override
    public Position makeMove(Position currentHead, String direction) {
        int row = currentHead.getRow();
        int col = currentHead.getCol();
        switch (direction) {
            case "U" -> {
                return new Position(row - 1, col);
            }
            case "D" -> {
                return new Position(row + 1, col);
            }
            case "L" -> {
                return new Position(row, col - 1);
            }
            case "R" -> {
                return new Position(row, col + 1);
            }
            default -> {
                return currentHead;
            }
        }
    }
}
