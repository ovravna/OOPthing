package games.sokoban.sokoban1;

//import java.util.*;

public class Point {
    protected Integer x, y;

    public static final Point RIGHT = Point.valueOf(0, 1);
    public static final Point LEFT = Point.valueOf(0, -1);
    public static final Point DOWN = Point.valueOf(1, 0);
    public static final Point UP = Point.valueOf(-1, 0);



    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Point point) {
        setPosition(point.getX(), point.getY());
    }

    public void setPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static Point valueOf(Integer x, Integer y) {
        return new Point(x, y);
    }

    public boolean isNear(Point point) {
        return isNear(point.getX(), point.getY());
    }

    public boolean isNear(int dx, int dy) {
        return Math.abs(x-dx)+Math.abs(y-dy) == 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Integer x, Integer y) {
        return this.x == x && this.y == y;
    }


    public Point add(Point p) {
        return new Point(x+p.getX(), y+p.getY());
    }



    public Point direction(Point point) {
        if (!this.isNear(point)) throw new IllegalArgumentException("Points are not near each other");

        int dx = point.getX()-x;
        int dy = point.getY()-y;

        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) throw new RuntimeException("Bug in direction()");

        return new Point(dx, dy);





    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point that = (Point) o;
        return this.x == that.x && this.y == that.y;

    }

}
