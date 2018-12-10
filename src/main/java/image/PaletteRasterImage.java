package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {
    private List<Color> palette = new ArrayList<>();
    private byte[][] indexesOfColors;
    private int height, width;

    public PaletteRasterImage(Color color, int width, int height) {
        super();
        this.setWidth(width);
        this.setHeight(height);
        this.createRepresentation();
        this.setPixelsColor(color);

    }

    public PaletteRasterImage(Color[][] pixels) {
        super();

        if (pixels.length == 0)
            throw new IllegalArgumentException("The given matrix was empty.");

        this.setWidth(pixels.length);
        this.setHeight(pixels[0].length);
        this.createRepresentation();
        this.setPixelsColor(pixels);
    }

    public void createRepresentation() {
        indexesOfColors = new byte[width][height];
    }

    public void setPixelColor(Color color, int x, int y) {
        if (!palette.contains(color))
            palette.add(color);

        indexesOfColors[x][y] = (byte) palette.indexOf(color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

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
