package Snake.ConcreteGame;

import Snake.*;
import Snake.FoodItemFactory.FoodItem;
import Snake.MovementStrategyPattern.MovementStrategy;
import Snake.ObserverPattern.GameObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SnakeGame implements BoardGame {
    private final Board board;
    private final Snake snake;
    private final FoodItem[] foodPosition;
    private int foodIndex;
    private boolean gameRunning;
    private final List<GameObserver> observers;

    public SnakeGame(MovementStrategy strategy, int width, int height, FoodItem[] foodPosition) {
        this.board = Board.getInstance(width, height);
        this.foodPosition = foodPosition;
        this.foodIndex = 0;
        this.gameRunning = true;
        this.snake = new Snake(strategy);
        this.observers = new ArrayList<>();
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void play() {
        System.out.println("SNAKE GAME");
        System.out.println("Control - W(Up), S(Down), A(Left), D(Right), Q(Quit)");

        Scanner sc = new Scanner(System.in);

        int score = 0;

        while (gameRunning) {
            displayGameState();
            System.out.println("Enter Move(W/A/S/D) or Q to Quit");

            String input = sc.nextLine().toUpperCase();

            if(input.equals("Q")) {
                System.out.println("Game ended by player. Final Score - " + score);
                gameRunning = false;
                continue;
            }

            String direction = convertInput(input);
            if(direction.isEmpty()) {
                System.out.println("Invalid input! Use W/A/S/D to Move or Q to Quit.");
                continue;
            }

            Position currentHead = snake.body.peekFirst();
            Position newHead = snake.getStrategy().makeMove(currentHead, direction);
            int newHeadRow = newHead.getRow();
            int newHeadCol = newHead.getCol();

            boolean crossBoundary = newHeadRow < 0 || newHeadRow >= board.getHeight() || newHeadCol < 0 || newHeadCol >= board.getWidth();
            Position currentTail = snake.body.peekLast();

            boolean biteItself = snake.positionMap.containsKey(newHead) &&
                    (newHeadRow != currentTail.getRow() && newHeadCol != currentTail.getCol());

            if(crossBoundary || biteItself) {
                System.out.println("GAME OVER! Score - " + score);
                notifyGameOver(score);
                gameRunning = false;
                continue;
            }

            boolean ateFood = foodIndex < foodPosition.length && (Objects.equals(foodPosition[foodIndex].getRow(), newHeadRow) && Objects.equals(foodPosition[foodIndex].getCol(), newHeadCol));
            if(ateFood) {
                score += foodPosition[foodIndex].getPoints();
                foodIndex += 1;
                notifyScoreUpdate(score);
            } else {
                snake.body.pollLast();
                snake.positionMap.remove(currentTail);
            }

            snake.body.addFirst(newHead);
            snake.positionMap.put(newHead, true);
            notifyMoveMade(newHead);
        }
    }

    private void displayGameState() {
        System.out.println("\nCurrent Snake length - " + snake.body.size());
    }

    private String convertInput(String input) {
        switch (input) {
            case "W" -> {
                return "U";
            }
            case "S" -> {
                return "D";
            }
            case "A" -> {
                return "L";
            }
            case "D" -> {
                return "R";
            }
            default -> {
                return "";
            }
        }
    }

    private void notifyMoveMade(Position newHead) {
        for(GameObserver observer : observers) {
            observer.onMoveMade(newHead);
        }
    }

    private void notifyGameOver(int score) {
        for(GameObserver observer : observers) {
            observer.onGameOver(score);
        }
    }

    private void notifyScoreUpdate(int score) {
        for(GameObserver observer : observers) {
            observer.onScoreUpdate(score);
        }
    }
}
