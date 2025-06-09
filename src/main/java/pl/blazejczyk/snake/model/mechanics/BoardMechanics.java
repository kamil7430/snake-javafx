package pl.blazejczyk.snake.model.mechanics;

import lombok.AllArgsConstructor;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.model.utilities.Tile;
import pl.blazejczyk.snake.utilities.Coords;

@AllArgsConstructor
public class BoardMechanics {
    private final Board board;

    public void placeNewFood() {
        Tile tile;
        do {
            tile = board.getRandomTile();
        } while (!tile.isFree());

        tile.setHasFood(true);
    }

    public boolean isTileFree(Coords coords) { //TODO: uwzględnić ogon
        return board.getTiles().get(coords).isFree();
    }

    public Tile getTileFromCoords(Coords coords) {
        return board.getTiles().get(coords);
    }

    public Coords moduloCoords(Coords coords) {
        return new Coords(coords.x() % board.getWidth(), coords.y() % board.getHeight());
    }

    public boolean tryRemoveFood(Coords coords) {
        Tile tile = board.getTiles().get(coords);
        if (!tile.isHasFood())
            return false;

        tile.setHasFood(false);
        return true;
    }
}
