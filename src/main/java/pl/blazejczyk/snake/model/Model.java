package pl.blazejczyk.snake.model;

import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.utilities.Direction;

public class Model {
    private final Board board;
    private final ModelMechanics modelMechanics;

    public Model(Board board) {
        this.board = board;
        this.modelMechanics = new ModelMechanics(this.board);
    }

    public void changeSnakeFacingDirection(Direction direction) {
        modelMechanics.changeSnakeFacingDirection(direction);
    }
}
