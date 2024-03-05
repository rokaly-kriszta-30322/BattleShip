package battleShip;

public class Coordinate {

    private int X;
    private int Y;

    public Coordinate() {
        X = 1;
        Y = 1;
    }

    public Coordinate(int x, int y){
        X=x;
        Y=y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "( " + X + ", " + Y + " )";
    }
}
