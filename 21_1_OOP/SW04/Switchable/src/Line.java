public final class Line {
    private Point pointA;
    private Point pointB;

    public Line(final int x1, final int y1, final int x2, final int y2){
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(final Point pointA, final Point pointB){
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
}
