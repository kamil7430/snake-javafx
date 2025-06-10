package pl.blazejczyk.snake.model;

import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.utilities.Direction;

public class Model {
    private final Board board;
    private final ModelMechanics modelMechanics;

    public Model() {
        this.board = new Board(10, 10); // TODO: jakoś uzmiennić
        this.modelMechanics = new ModelMechanics(this.board);
    }

    public void changeSnakeFacingDirection(Direction direction) {
        modelMechanics.changeSnakeFacingDirection(direction);
    }
}
