package pl.blazejczyk.snake.model.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.blazejczyk.snake.utilities.Coords;

@Setter
@Getter
public class Tile {
    private final Coords coords;
    private boolean hasFood;
    private boolean isSnakeOn;

    public Tile(Coords coords) {
        this.coords = coords;
        hasFood = false;
        isSnakeOn = false;
    }

    public boolean isFree() {
        return !(hasFood || isSnakeOn);
    }
}
