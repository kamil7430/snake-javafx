package pl.blazejczyk.snake.view.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import lombok.Getter;
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

        BoardEntity[][] boardEntities = visualBoard.getBoard();
        for (int i = 0; i < visualBoard.getWidth(); i++) {
            for (int j = 0; j < visualBoard.getHeight(); j++) {
                gridPane.add(makeTile(boardEntities[i][j]), i, j);
            }
        }
    }

    private Region makeTile(BoardEntity boardEntity) {
        Region region = new Region();

        region.setMinWidth(TILE_SIZE);
        region.setMaxWidth(TILE_SIZE);
        region.setMinHeight(TILE_SIZE);
        region.setMaxHeight(TILE_SIZE);

        switch (boardEntity) {
            case Empty ->
                region.setBackground(RegionBackgroundFlyweight.GRAY);
            case SnakeHead, SnakeBody, SnakeTail ->
                region.setBackground(RegionBackgroundFlyweight.GREEN);
            case Food ->
                region.setBackground(RegionBackgroundFlyweight.RED);
        }

        return region;
    }
}
