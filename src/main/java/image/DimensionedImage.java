package image;

public abstract class DimensionedImage implements Image {

    protected int height, width;

    public DimensionedImage(int width, int height) {
        super();
        this.height = height;
        this.width = width;
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
