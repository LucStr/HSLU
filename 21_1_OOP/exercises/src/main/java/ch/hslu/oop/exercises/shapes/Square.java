package ch.hslu.oop.exercises.shapes;

public final class Square extends Shape {
    private int width;

    public Square(int x, int y, int width){
        super(x, y);

        this.width = width;
    }

    public void changeDimension(int newWidth){
        this.width = newWidth;
    }

    @Override
    public int getPerimeter() {
        return 4 * width;
    }

    @Override
    public int getArea() {
        return width * width;
    }
}
