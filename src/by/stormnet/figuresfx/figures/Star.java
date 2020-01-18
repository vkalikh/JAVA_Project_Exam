package by.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Star extends Figure {
    private double radius;

    public Star(double cx, double cy, double lineWidth, Color color, double radius) {
        super(Figure.FIGURE_TYPE_STAR, cx, cy, lineWidth, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double side) {
        this.radius = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Double.compare(star.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Star{" +
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
                        cx + Math.sin(36 * (Math.PI / 180)) * (radius / 2),
                        cx + Math.cos(18 * (Math.PI / 180)) * radius,
                        cx + Math.cos(18 * (Math.PI / 180)) * (radius / 2),
                        cx + Math.sin(36 * (Math.PI / 180)) * radius,
                        cx,
                        cx - Math.sin(36 * (Math.PI / 180)) * radius,
                        cx - Math.cos(18 * (Math.PI / 180)) * (radius / 2),
                        cx - Math.cos(18 * (Math.PI / 180)) * radius,
                        cx - Math.sin(36 * (Math.PI / 180)) * (radius / 2),
                },
                new double[]{
                        cy - radius,
                        cy - Math.cos(36 * (Math.PI / 180)) * (radius / 2),
                        cy - Math.sin(18 * (Math.PI / 180)) * radius,
                        cy + Math.sin(18 * (Math.PI / 180)) * (radius / 2),
                        cy + Math.cos(36 * (Math.PI / 180)) * radius,
                        cy + (radius / 2),
                        cy + Math.cos(36 * (Math.PI / 180)) * radius,
                        cy + Math.sin(18 * (Math.PI / 180)) * (radius / 2),
                        cy - Math.sin(18 * (Math.PI / 180)) * radius,
                        cy - Math.cos(36 * (Math.PI / 180)) * (radius / 2)

                },
                10
        );
    }
}
