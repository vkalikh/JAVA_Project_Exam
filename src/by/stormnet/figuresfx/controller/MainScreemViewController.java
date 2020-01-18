package by.stormnet.figuresfx.controller;

import by.stormnet.figuresfx.drawutils.Drawer;
import by.stormnet.figuresfx.exceptions.FigureException;
import by.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.*;

public class MainScreemViewController implements Initializable {
    private static final Logger log = Logger.getLogger(MainScreemViewController.class);
    private List<Figure> figures1 = new ArrayList<>();
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random(System.currentTimeMillis());
        log.info("Test");
    }

    private void addFigure(Figure figure) {
        figures1.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException {
        Figure figure = null;

        switch (random.nextInt(6)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(4), Color.RED, random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.BLUE, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(x, y, random.nextInt(4), Color.BLACK, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_PENTAGON:
                figure = new Pentagon(x, y, random.nextInt(4), Color.BROWN, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_HEXAGON:
                figure = new Hexagon(x, y, random.nextInt(4), Color.GRAY, random.nextInt(100));
                break;
            default:
                throw new FigureException("Unknown figure!");
        }
        return figure;
    }

    private void repaint() throws FigureException {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures1);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onClicked(MouseEvent mouseEvent) throws FigureException {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }
}
