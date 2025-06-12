package pl.blazejczyk.snake.view.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import pl.blazejczyk.snake.utilities.Direction;
import pl.blazejczyk.snake.view.IScene;
import pl.blazejczyk.snake.view.utilities.BoardEntity;
import pl.blazejczyk.snake.view.utilities.RegionBackgroundFlyweight;
import pl.blazejczyk.snake.view.utilities.VisualBoard;

public class BoardScene implements IScene {
    private static final int TILE_SIZE = 50;
    @Getter
    private Scene scene;

    public void updateScene(VisualBoard visualBoard) {
        GridPane gridPane = new GridPane();
        scene = new Scene(gridPane);

        for (int i = 0; i < visualBoard.getWidth(); i++) {
            for (int j = 0; j < visualBoard.getHeight(); j++) {
                BoardEntity boardEntity = visualBoard.getBoard()[i][j];
                Direction direction = visualBoard.getDirections()[i][j];
                gridPane.add(makeTile(boardEntity, direction), i, j);
            }
        }
    }

    private Label makeTile(BoardEntity boardEntity, Direction direction) {
        Label label = new Label("");

        label.setMinWidth(TILE_SIZE);
        label.setMaxWidth(TILE_SIZE);
        label.setMinHeight(TILE_SIZE);
        label.setMaxHeight(TILE_SIZE);

        switch (boardEntity) {
            case Empty ->
                label.setBackground(RegionBackgroundFlyweight.GRAY);
            case SnakeHead, SnakeBody, SnakeTail ->
                label.setBackground(RegionBackgroundFlyweight.GREEN);
            case Food ->
                label.setBackground(RegionBackgroundFlyweight.RED);
        }

        if (direction != null) {
            label.setText(direction.name());
        }

        return label;
    }
}
