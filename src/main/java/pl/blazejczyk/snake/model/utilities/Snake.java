package pl.blazejczyk.snake.model.utilities;

import lombok.Getter;
import lombok.Setter;
import pl.blazejczyk.snake.utilities.Direction;

import java.util.LinkedList;

@Getter
@Setter
public class Snake {
    private int length;
    private Direction facing;
    private final LinkedList<Tile> body;

    public Snake(Direction facing, Tile start) {
        this.length = 1;
        this.facing = facing;
        this.body = new LinkedList<>();
        this.body.add(start);
    }
}
