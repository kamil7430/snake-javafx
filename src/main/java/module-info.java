module pl.blazejczyk.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;


    opens pl.blazejczyk.snake to javafx.fxml;
    exports pl.blazejczyk.snake;
}