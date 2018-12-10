package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class SparseRasterImage extends RasterImage {

    private HashMap<Point, Color> links;

    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] colors) {
        super(colors);
    }

    @Override
    public void createRepresentation() {
        links = new HashMap<>();
    }

    @Override
    public void setPixelColor(Color color, int x, int y) {
        if (color != Color.WHITE)
            links.put(new Point(x, y), color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            throw new NoSuchElementException("Trying to access a pixel that doesn't exist.");

        return links.getOrDefault(new Point(x, y), Color.WHITE);
    }
}
