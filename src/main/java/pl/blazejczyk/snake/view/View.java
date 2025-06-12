package pl.blazejczyk.snake.view;

import javafx.stage.Stage;
import pl.blazejczyk.snake.controller.Controller;
import pl.blazejczyk.snake.view.utilities.VisualBoard;

public class View {
    private final StageManager stageManager;
    private final Controller controller;

    public View(Stage stage, Controller controller) {
        this.stageManager = new StageManager(stage, this);
        this.controller = controller;
    }

    public void run() {
        stageManager.run();
    }

    public VisualBoard getVisualBoard() {
        return controller.getVisualBoard();
    }
}
