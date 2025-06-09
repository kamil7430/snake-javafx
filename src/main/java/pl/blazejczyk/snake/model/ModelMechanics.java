package pl.blazejczyk.snake.model;

import pl.blazejczyk.snake.model.mechanics.BoardMechanics;
import pl.blazejczyk.snake.model.mechanics.SnakeMechanics;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.utilities.Coords;
import pl.blazejczyk.snake.utilities.Direction;

public class ModelMechanics {
    private final BoardMechanics boardMechanics;
    private final SnakeMechanics snakeMechanics;

    public ModelMechanics(Board board) {
        boardMechanics = new BoardMechanics(board);
        snakeMechanics = new SnakeMechanics(board.getSnake());
    }

    public void changeSnakeFacingDirection(Direction direction) {
        snakeMechanics.changeFacingDirection(direction);
    }

    public boolean tryMoveSnake() {
        Coords newCoords = boardMechanics.moduloCoords(snakeMechanics.getPossibleNewCoords());
        if (!boardMechanics.isTileFree(newCoords))
            return false;

        boolean ateFood = boardMechanics.tryRemoveFood(newCoords);
        snakeMechanics.move(boardMechanics.getTileFromCoords(newCoords), ateFood);
        if (ateFood)
            boardMechanics.placeNewFood();

        return true;
    }
}
