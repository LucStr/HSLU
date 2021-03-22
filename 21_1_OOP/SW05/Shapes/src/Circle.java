public class Circle extends Shape {
    private int diameter;

    public Circle(int x, int y, int diameter){
        super(x, y);

        this.diameter = diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    private float getRadius(){
        return this.diameter / 2f;
    }

    @Override
    public int getPerimeter() {
        var perimeter = 2 * Math.PI * getRadius();

        return (int) Math.round(perimeter);
    }

    @Override
    public int getArea() {
        var area = Math.pow(getRadius(), 2) * Math.PI;

        return (int) Math.round(area);
    }
}
