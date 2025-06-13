package pl.blazejczyk.snake;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.blazejczyk.snake.controller.Controller;

public class SnakeApplication extends Application {

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller(stage);
        controller.runGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}