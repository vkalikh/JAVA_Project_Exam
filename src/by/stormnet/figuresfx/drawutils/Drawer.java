package by.stormnet.figuresfx.drawutils;

import by.stormnet.figuresfx.exceptions.FigureException;
import by.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Drawer<T extends Figure & Drawable> {
    private List<T> figures1;

    public Drawer(List<T> figures1) {
        this.figures1 = figures1;
    }

//Generic коллекция, хранящая массив фигур для отрисовки
//Конструктор, в котором данная коллекция типизируется
//Реализация метода draw(), который отрисовывает фигуры в коллекции

    public void draw(GraphicsContext gc) throws FigureException {
        for (T a : figures1) {
            if (a != null) {
                a.draw(gc);
            } else {
                throw new FigureException("No figures");
            }
        }
    }
}
