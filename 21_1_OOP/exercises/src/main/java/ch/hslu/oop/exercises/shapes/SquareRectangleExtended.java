package ch.hslu.oop.exercises.shapes;

public final class SquareRectangleExtended extends Rectangle {
    public SquareRectangleExtended(int x, int y, int width) {
        super(x, y, width, width);
    }

    @Override
    public int getHeight() {
        return getWidth();
    }

    @Override
    public void changeDimension(int newWidth, int newHeight){
        super.changeDimension(newWidth, newWidth);
    }
}
