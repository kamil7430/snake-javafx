package pl.blazejczyk.snake.model.mechanics;

import lombok.AllArgsConstructor;
import pl.blazejczyk.snake.model.utilities.Snake;
import pl.blazejczyk.snake.model.utilities.Tile;
import pl.blazejczyk.snake.utilities.Coords;
import pl.blazejczyk.snake.utilities.Direction;

@AllArgsConstructor
public class SnakeMechanics {
    private final Snake snake;

    public void changeFacingDirection(Direction direction) {
        snake.setFacing(direction);
    }

    public Coords getPossibleNewCoords() {
        Coords coords = snake.getBody().getFirst().getCoords();
        return coords.goInDirection(snake.getFacing());
    }

    public void move(Tile destinationTile, boolean ateFood) {
        snake.getBody().addFirst(destinationTile);
        destinationTile.setSnakeOn(true);
        if (ateFood)
            snake.setLength(snake.getLength() + 1);
        else
        {
            Tile last = snake.getBody().removeLast();
            last.setSnakeOn(false);
        }
    }
}
