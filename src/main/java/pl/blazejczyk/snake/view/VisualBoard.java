package pl.blazejczyk.snake.view;

import lombok.Getter;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.model.utilities.Tile;
import pl.blazejczyk.snake.view.utilities.BoardEntity;

@Getter
public class VisualBoard {
    private final BoardEntity[][] board;

    public VisualBoard(Board board) {
        this.board = new BoardEntity[board.getWidth()][board.getHeight()];

        board.getTiles().forEach((coords, tile) -> {
            this.board[coords.x()][coords.y()] = tile.isHasFood() ? BoardEntity.Food : BoardEntity.Empty;
        });

        for (Tile tile : board.getSnake().getBody()) {
            this.board[tile.getCoords().x()][tile.getCoords().y()] = BoardEntity.SnakeBody;
        }

        Tile first = board.getSnake().getBody().getFirst();
        this.board[first.getCoords().x()][first.getCoords().y()] = BoardEntity.SnakeHead;

        if (board.getSnake().getBody().size() > 1) {
            Tile last = board.getSnake().getBody().getLast();
            this.board[last.getCoords().x()][last.getCoords().y()] = BoardEntity.SnakeTail;
        }
    }
}
