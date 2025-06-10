package pl.blazejczyk.snake.controller;

import pl.blazejczyk.snake.model.Model;
import pl.blazejczyk.snake.model.utilities.Board;
import pl.blazejczyk.snake.view.View;

public class Controller {
    private final Model model;
    private final View view;

    public Controller() {
        this.model = new Model();
        this.view = new View();
    }
}
