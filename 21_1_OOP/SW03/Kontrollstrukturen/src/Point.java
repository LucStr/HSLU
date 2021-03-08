public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getQuadrant(){
        if(x == 0 || y == 0){
            return 0;
        }

        if(x > 0){
            return y > 0 ? 1 : 4;
        } else {
            return y > 0 ? 2 : 3;
        }
    }
}
