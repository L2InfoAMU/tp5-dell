package image;

import javafx.scene.paint.Color;

public abstract class RasterImage extends DimensionedImage {
    public RasterImage(Color color, int width, int height) {
        super(width, height);
        this.createRepresentation();
        this.setPixelsColor(color);
    }

    public RasterImage(Color[][] colors) {
        super(colors.length, (colors.length > 0) ? colors[0].length : 0);

        if (colors.length == 0)
            throw new IllegalArgumentException("The given matrix was empty.");

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

}
