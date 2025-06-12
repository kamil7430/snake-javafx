package pl.blazejczyk.snake.view;

import javafx.stage.Stage;
import pl.blazejczyk.snake.view.scenes.BoardScene;
import pl.blazejczyk.snake.view.utilities.VisualBoard;

public class StageManager {
    private final Stage stage;
    private final View view;
    private IScene currentScene;
    private final BoardScene boardScene;

    public StageManager(Stage stage, View view) {
        this.stage = stage;
        this.view = view;
        this.boardScene = new BoardScene();
        this.currentScene = null;
    }

    // TODO: do zmiany
    public void run() {
        showOrUpdateBoardScene(view.getVisualBoard());
        stage.setTitle("Snake by Kamil:)");
        stage.setScene(currentScene.getScene());
        stage.sizeToScene();
        stage.show();
    }

    public void showOrUpdateBoardScene(VisualBoard visualBoard) {
        if (visualBoard != null) {
            boardScene.updateScene(visualBoard);
        }
        currentScene = boardScene;
    }
}
