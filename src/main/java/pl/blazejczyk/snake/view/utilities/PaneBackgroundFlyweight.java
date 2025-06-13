package pl.blazejczyk.snake.view.utilities;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class PaneBackgroundFlyweight {
    public static Background BLACK;
    public static Background GRAY;
    public static Background GREEN;
    public static Background RED;

    static {
        BLACK = new Background(new BackgroundFill(Color.BLACK, null, null));
        GRAY = new Background(new BackgroundFill(Color.GRAY, null, null));
        GREEN = new Background(new BackgroundFill(Color.FORESTGREEN, null, null));
        RED = new Background(new BackgroundFill(Color.INDIANRED, null, null));
    }
}
