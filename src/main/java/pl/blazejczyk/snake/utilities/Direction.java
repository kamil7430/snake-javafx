package pl.blazejczyk.snake.utilities;

public enum Direction {
    Up,
    Down,
    Left,
    Right;

    public int getImageRotation() {
        return switch (this) {
            case Up -> 90;
            case Down -> 270;
            case Left -> 180;
            case Right -> 0;
        };
    }
}
