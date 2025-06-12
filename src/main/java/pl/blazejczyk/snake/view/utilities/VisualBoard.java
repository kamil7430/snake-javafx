package pl.blazejczyk.snake.view.utilities;

import lombok.Getter;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.model.utilities.Tile;
import pl.blazejczyk.snake.utilities.Coords;
import pl.blazejczyk.snake.utilities.Direction;

@Getter
public class VisualBoard {
    private final int width;
    private final int height;
    private final BoardEntity[][] board;
    private final Direction[][] directions;

    public VisualBoard(Board board) {
        this.width = board.getWidth();
        this.height = board.getHeight();
        this.board = new BoardEntity[this.width][this.height];
        this.directions = new Direction[this.width][this.height];

        board.getTiles().forEach((coords, tile) -> {
            this.board[coords.x()][coords.y()] = tile.isHasFood() ? BoardEntity.Food : BoardEntity.Empty;
        });

        Coords previous = null;
        for (Tile tile : board.getSnake().getBody()) {
            Coords coords = tile.getCoords();
            this.board[coords.x()][coords.y()] = BoardEntity.SnakeBody;

            if (previous != null)
                this.directions[coords.x()][coords.y()] = previous.directionTo(coords);
            previous = coords;
        }

        Tile first = board.getSnake().getBody().getFirst();
        this.board[first.getCoords().x()][first.getCoords().y()] = BoardEntity.SnakeHead;
        this.directions[first.getCoords().x()][first.getCoords().y()] = board.getSnake().getFacing();

        if (board.getSnake().getBody().size() > 1) {
            Tile last = board.getSnake().getBody().getLast();
            this.board[last.getCoords().x()][last.getCoords().y()] = BoardEntity.SnakeTail;
        }
    }
}
