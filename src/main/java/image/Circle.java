package image;

import javafx.scene.paint.Color;

public class Circle implements Shape {

    private final Point center;
    private final double radius;
    private final Color color;

    public Circle(int x, int y, double radius, Color color) {
        super();
        this.center = new Point(x, y);
        this.radius = radius;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return distanceBetween(center, point) <= radius;
    }

    private double distanceBetween(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    @Override
    public Color getColor() {
        return color;
    }
}
