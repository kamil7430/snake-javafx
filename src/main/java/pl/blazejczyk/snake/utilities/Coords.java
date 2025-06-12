package pl.blazejczyk.snake.utilities;

public record Coords(int x, int y) {
    public Coords goInDirection(Direction direction) {
        switch (direction) {
            case Up -> {
                return new Coords(x, y - 1);
            }
            case Down -> {
                return new Coords(x, y + 1);
            }
            case Left -> {
                return new Coords(x - 1, y);
            }
            case Right -> {
                return new Coords(x + 1, y);
            }
        }
        return null;
    }

    public Direction directionTo(Coords to) {
        if (to.x() - x != 0 && to.y() - y != 0)
            return null;
        if (to.x() - x > 0)
            return Direction.Right;
        if (to.x() - x < 0)
            return Direction.Left;
        if (to.y() - y > 0)
            return Direction.Down;
        if (to.y() - y < 0)
            return Direction.Up;
        return null;
    }
}
