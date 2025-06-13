package pl.blazejczyk.snake.view.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import pl.blazejczyk.snake.utilities.Direction;
import pl.blazejczyk.snake.view.IScene;
import pl.blazejczyk.snake.view.utilities.BoardEntity;
import pl.blazejczyk.snake.view.utilities.PaneBackgroundFlyweight;
import pl.blazejczyk.snake.view.utilities.PaneImageFlyweight;
import pl.blazejczyk.snake.view.utilities.VisualBoard;

public class BoardScene implements IScene {
    private static final int TILE_SIZE = 50;
    @Getter
    private Scene scene = null;

    public void updateScene(VisualBoard visualBoard) {
        GridPane gridPane = new GridPane();
        if (this.scene == null)
            this.scene = new Scene(gridPane);
        scene.setRoot(gridPane);

        for (int i = 0; i < visualBoard.getWidth(); i++) {
            for (int j = 0; j < visualBoard.getHeight(); j++) {
                BoardEntity boardEntity = visualBoard.getBoard()[i][j];
                Direction direction = visualBoard.getDirections()[i][j];
                gridPane.add(makeTile(boardEntity, direction), i, j);
            }
        }
    }

    private Node makeTile(BoardEntity boardEntity, Direction direction) {
        StackPane pane = new StackPane();

        pane.setMinWidth(TILE_SIZE);
        pane.setMaxWidth(TILE_SIZE);
        pane.setMinHeight(TILE_SIZE);
        pane.setMaxHeight(TILE_SIZE);

        pane.setBackground(PaneBackgroundFlyweight.GRAY);

        if (boardEntity == BoardEntity.Empty)
            return pane;

        ImageView imageView = new ImageView();
        imageView.setFitWidth(TILE_SIZE);
        imageView.setFitHeight(TILE_SIZE);

        switch (boardEntity) {
            case SnakeHead -> {
                imageView.setImage(PaneImageFlyweight.SNAKE_HEAD);
                imageView.setRotate(direction.getImageRotation());
            }
            case SnakeBody -> {
                imageView.setImage(PaneImageFlyweight.SNAKE_BODY);
                imageView.setRotate(direction.getImageRotation());
            }
            case SnakeTail -> {
                imageView.setImage(PaneImageFlyweight.SNAKE_TAIL);
                imageView.setRotate(direction.getImageRotation());
            }
            case Food -> imageView.setImage(PaneImageFlyweight.FOOD);
        }
        pane.getChildren().add(imageView);

        return pane;
    }
}
