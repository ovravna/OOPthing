package Sokoban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finder {
    static int startx = 0, starty = 0;
    static List<List<Integer>> map = new ArrayList<>();


    public static String findPath(String level, int xPos, int yPos) {
        int x = 0, y = 0;
        map.add(new ArrayList<>());

        for (char cell : level.toCharArray()) {
            switch (cell) {
                case '\n':
                case '|':
                    y++;
                    x = -1;
                    map.add(new ArrayList<>());
                    break;
                case ' ':
                case '.':
                    map.get(y).add(0);
                    break;
                case '#':
                case '$':
                case '*':
                case 'X':
                    map.get(y).add(4);
                    break;
                case '@':
                case '+':
                    map.get(y).add(0);
                    startx = x;
                    starty = y;
                    break;
            }
            x++;
        }
        if (map.get(yPos).get(xPos) == 4) {
            return null;
        }

        int xq = startx;
        int yq = starty;

        List<Point2D> moves = new ArrayList<>();

        for (int i = 0;true;i++) {
            Point2D nextPoint = findNeighbour(xq, yq);

            if (nextPoint == null) {
                String directions = "";
                System.out.println();
                System.out.println(i);
                for (Point2D move : moves) {
                    directions += move.dir;
                }
                return directions;
            }

            xq = nextPoint.getX();
            yq = nextPoint.getY();
//            if (moves.contains(nextPoint)) {
//                moves = moves.subList(0, moves.indexOf(nextPoint)+1);
//            } else {
//            }
            moves.add(nextPoint);
            map.get(yq).set(xq, map.get(yq).get(xq) + 1);
            System.out.print(nextPoint.dir);

            if (xq == xPos && yq == yPos) {
                String directions = "";
                System.out.println();
                System.out.println(i);
                for (Point2D move : moves) {
                    directions += move.dir;
                }

                System.out.println("YOU HAVE WON!!! MOFO!");
                return directions;
            }
        }
    }

    private static Point2D findNeighbour(int x, int y) {
        Point2D down = new Point2D(x, y+1, map.get(y+1).get(x), 'd');
        Point2D up = new Point2D(x, y-1, map.get(y-1).get(x), 'u');
        Point2D left = new Point2D(x-1, y, map.get(y).get(x-1), 'l');
        Point2D right = new Point2D(x+1, y, map.get(y).get(x+1), 'r');
        List<Point2D> dir = Arrays.asList(down, right, left, up);
        dir.sort(null);


        if (dir.get(0).val == 4) {
            return null;
        }

        if (dir.get(0).val != 0 && dir.get(1).val == 4) {
            map.get(y).set(x, 4);
        }

        return dir.get(0);
    }

}
class Point2D implements Comparable{
    int x;
    int y;
    int val;
    char dir;

    public Point2D(int x, int y, int val, char dir) {

        this.x = x;
        this.y = y;
        this.val = val;
        this.dir = dir;
    }

    public void increment() {
        val++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVal() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;
        return y == point2D.y && x == point2D.x;

    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Point2D)) {
            throw new RuntimeException();
        }
        return this.val-((Point2D) o).val;
    }

    @Override
    public String toString() {
        return  "x="+x+
                ", y="+y+
                ", dir="+dir;
    }
}






