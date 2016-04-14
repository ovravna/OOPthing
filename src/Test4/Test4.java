package Test4;
// Funker ikke??


public class Test4 {
    public static void main(String[] args) {
        System.out.println("kake!");




        Rectangle rect = new Rectangle(-1,-1,1,1);
        Rectangle rect2 = new Rectangle();
        rect.add(1, 1);
        rect.add(2, 5);
        coor(rect);
        System.out.println();
        rect2.add(-1, 2);
        coor(rect2);
        rect2.add(-2, -1);
        coor(rect2);

        Rectangle rect3 = rect.intersection(rect2);
        show(rect3);
        coor(rect3);
    }

    static void show(Rectangle rect) {
        System.out.println("Høyde: "+rect.getHight());
        System.out.println("Bredde: "+rect.getWidth());
    }

    static void coor(Rectangle rect) {
        String x = String.format("Minimum: %d, %d", rect.getMinX(), rect.getMinY());
        String y = String.format("Maximum: %d, %d", rect.getMaxX(), rect.getMaxY());
        System.out.println(x);
        System.out.println(y);
    }
}

