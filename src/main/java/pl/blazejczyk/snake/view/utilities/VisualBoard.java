package pl.blazejczyk.snake.view.utilities;

import lombok.Getter;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.model.utilities.Tile;

@Getter
public class VisualBoard {
    private final int width;
    private final int height;
    private final BoardEntity[][] board;

    public VisualBoard(Board board) {
        this.width = board.getWidth();
        this.height = board.getHeight();
        this.board = new BoardEntity[this.width][this.height];

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
