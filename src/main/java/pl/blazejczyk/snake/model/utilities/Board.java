package pl.blazejczyk.snake.model.utilities;

import lombok.Getter;
import lombok.Setter;
import pl.blazejczyk.snake.utilities.Coords;
import pl.blazejczyk.snake.utilities.Direction;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class Board {
    private final int width;
    private final int height;
    private final HashMap<Coords, Tile> tiles;
    private final Snake snake;
    private final Random random;

    public Board(int width, int height) {
        this.random = new Random();
        this.width = width;
        this.height = height;
        this.tiles = new HashMap<>(width * height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Coords coords = new Coords(i, j);
                tiles.put(coords, new Tile(coords));
            }
        }
        this.snake = new Snake(Direction.Right, getRandomTile());
    }

    public Tile getRandomTile() {
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        return tiles.get(new Coords(x, y));
    }
}
