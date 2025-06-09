module pl.blazejczyk.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens pl.blazejczyk.snake to javafx.fxml;
    exports pl.blazejczyk.snake;
}