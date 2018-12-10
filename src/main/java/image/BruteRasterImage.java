package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    private Color[][] matrix;
    private int width, height;

    public BruteRasterImage(Color color, int width, int height) {
        super();
        this.setHeight(height);
        this.setWidth(width);
        this.createRepresentation();
        this.setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors) {
        super();

        if (colors.length == 0)
            throw new IllegalArgumentException("The given matrix was empty.");

        this.setWidth(colors.length);
        this.setHeight(colors[0].length);
        this.setPixelsColor(colors);
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

    private void setPixelsColor(Color[][] pixels) {
        matrix = pixels;
    }

    private void setPixelsColor(Color color) {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                matrix[i][j] = color;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}
