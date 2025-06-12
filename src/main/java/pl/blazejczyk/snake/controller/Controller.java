package pl.blazejczyk.snake.controller;

import javafx.stage.Stage;
import pl.blazejczyk.snake.model.Model;
import pl.blazejczyk.snake.view.View;
import pl.blazejczyk.snake.view.utilities.VisualBoard;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Stage stage) {
        this.model = new Model();
        this.view = new View(stage, this);
    }

    public void runGame() {
        // TODO: run model and view
        model.run();
        view.run();
    }

    public VisualBoard getVisualBoard() {
        return new VisualBoard(model.getBoard());
    }
}
