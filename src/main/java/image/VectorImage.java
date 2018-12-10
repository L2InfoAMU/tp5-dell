package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage extends DimensionedImage {
    private final List<Shape> shapes;

    public VectorImage(List<Shape> shapes, int width, int height) {
        super(width, height);
        this.shapes = shapes;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Point p = new Point(x, y);

        for (Shape shape: shapes)
            if (shape.contains(p))
                return shape.getColor();

        return Color.WHITE;
    }

}
