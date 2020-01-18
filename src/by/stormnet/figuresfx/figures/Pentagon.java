package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Pentagon extends Figure {
    private double radius;

    public Pentagon(double cx, double cy, double lineWidth, Color color, double radius) {
        super(Figure.FIGURE_TYPE_PENTAGON, cx, cy, lineWidth, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pentagon pentagon = (Pentagon) o;
        return Double.compare(pentagon.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Pentagon{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                        cx,
                        cx + Math.cos(18 * (Math.PI / 180)) * radius,
                        cx + Math.sin(36 * (Math.PI / 180)) * radius,
                        cx - Math.sin(36 * (Math.PI / 180)) * radius,
                        cx - Math.cos(18 * (Math.PI / 180)) * radius,
                },
                new double[]{
                        cy - radius,
                        cy - Math.sin(18 * (Math.PI / 180)) * radius,
                        cy + Math.cos(36 * (Math.PI / 180)) * radius,
                        cy + Math.cos(36 * (Math.PI / 180)) * radius,
                        cy - Math.sin(18 * (Math.PI / 180)) * radius
                },
                5);
    }
}
