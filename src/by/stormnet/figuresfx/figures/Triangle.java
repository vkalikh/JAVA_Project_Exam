package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double base;

    public Triangle(double cx, double cy, double lineWidth, Color color, double base) {
        super(Figure.FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
        this.base = base < 10 ? 10 : base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                        cx,
                        cx - base / 2,
                        cx + base / 2
                },
                new double[]{
                        cy - base / Math.sqrt(3),
                        cy + base / (Math.sqrt(3) * 2),
                        cy + base / (Math.sqrt(3) * 2)},
                3);
    }
}
