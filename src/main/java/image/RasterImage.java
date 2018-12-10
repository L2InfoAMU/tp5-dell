package image;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image {
    protected int width, height;

    public RasterImage(Color color, int width, int height) {
        super();
        this.setHeight(height);
        this.setWidth(width);
        this.createRepresentation();
        this.setPixelsColor(color);
    }

    public RasterImage(Color[][] colors) {
        super();

        if (colors.length == 0)
            throw new IllegalArgumentException("The given matrix was empty.");

        this.setWidth(colors.length);
        this.setHeight(colors[0].length);
        this.setPixelsColor(colors);
    }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);

    private void setPixelsColor(Color[][] pixels) {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                setPixelColor(pixels[i][j], i, j);
    }

    private void setPixelsColor(Color color) {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                setPixelColor(color, i, j);
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
