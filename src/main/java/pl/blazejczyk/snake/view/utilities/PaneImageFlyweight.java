package pl.blazejczyk.snake.view.utilities;

import javafx.scene.image.Image;

import java.util.Objects;

public class PaneImageFlyweight {
    public static Image FOOD;
    public static Image SNAKE_HEAD;
    public static Image SNAKE_BODY;
    public static Image SNAKE_TAIL;

    static {
        FOOD = new Image(Objects.requireNonNull(PaneImageFlyweight.class.getResourceAsStream("/board/apple.png")));
        SNAKE_HEAD = new Image(Objects.requireNonNull(PaneImageFlyweight.class.getResourceAsStream("/board/snakeHead.png")));
        SNAKE_BODY = new Image(Objects.requireNonNull(PaneImageFlyweight.class.getResourceAsStream("/board/snakeBody.png")));
        SNAKE_TAIL = new Image(Objects.requireNonNull(PaneImageFlyweight.class.getResourceAsStream("/board/snakeTail.png")));
    }
}
