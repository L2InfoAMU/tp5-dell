package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {
    private Color[][] matrix;

    public BruteRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] colors) {
        super(colors);
    }

    public void createRepresentation() {
        matrix = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y) {
        matrix[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return matrix[x][y];
    }

}
