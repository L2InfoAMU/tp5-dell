package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image {
    private final List<Shape> shapes;
    private final int width, height;

    public VectorImage(List<Shape> shapes, int width, int height) {
        super();
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Point p = new Point(x, y);

        for (Shape shape: shapes)
            if (shape.contains(p))
                return shape.getColor();

        return Color.WHITE;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
