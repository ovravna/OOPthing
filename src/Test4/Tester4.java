package Test4;

public class Tester4 {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(1, 1, 0, 0);
        Rectangle rect2 = new Rectangle(-1,-1,0,0);
        Rectangle rectangle3 = rect.union(rect2);

        System.out.println(rect);
        System.out.println(rect2);
        System.out.println(rectangle3);
    }

    static void show(Rectangle rect) {
        System.out.println("Høyde:    "+rect.getHeight());
        System.out.println("Bredde:   "+rect.getWidth());
        System.out.println();
    }

    static void coor(Rectangle rect) {
        String x = String.format("Minimum: %2d, %2d", rect.getMinX(), rect.getMinY());
        String y = String.format("Maximum: %2d, %2d", rect.getMaxX(), rect.getMaxY());
        System.out.println(x);
        System.out.println(y);
        System.out.println();
    }
}













