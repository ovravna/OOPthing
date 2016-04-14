package Test4;


public class Rectangle {
    private int minY,minX,maxY,maxX;
    private static int count;
    private final int NUM;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    //Overload
    public Rectangle(int maxX, int maxY) {
        this(0, 0, maxX, maxY);
    }

    //Overload
    public Rectangle(Rectangle r) {
        this(r.getMaxX(), r.getMaxY(), r.getMinX(), r.getMinY());
    }

    //Overload
    public Rectangle(int minX, int minY, int maxX, int maxY) {
        this.minY = minY;
        this.minX = minX;
        this.maxY = maxY;
        this.maxX = maxX;
        count++;
        NUM = count;
    }

    boolean isEmpty() {
        return this.getHeight() == 0 || this.getWidth() == 0;
    }

    boolean contains(int x, int y) {
        return (x <= maxX &&
                x >= minX &&
                y <= maxY &&
                y >= minY) ||
                (x <= minX &&
                x >= maxX &&
                y <= minY &&
                y >= maxY);
    }

    //Overload
    boolean contains(Rectangle r) {
//        return r.minY >= minY && r.maxY <= maxY && r.minX >= minX && r.maxX <= maxX;
        return (r.maxX <= maxX &&
                r.minX >= minX &&
                r.maxY <= maxY &&
                r.maxY >= minY) ||
                (r.maxX <= minX &&
                r.minX >= maxX &&
                r.maxY <= minY &&
                r.minY >= maxY);
    }

    boolean add(int x, int y) {
        if (contains(x, y))
            return false;
        else {
            if (y <= maxY && y >= minY) {
                if (Math.abs(x-minX) > Math.abs(x-maxX)) {
                    maxX = x;
                } else minX = x;
            } else if (x <= maxX && x >= minX) {
                if (Math.abs(y-minY) > Math.abs(y-maxY)) {
                    maxY = y;
                } else minY = y;
            } else {
                if (Math.abs(x-minX) > Math.abs(x-maxX)) {
                    maxX = x;
                } else minX = x;
                if (Math.abs(y-minY) > Math.abs(y-maxY)) {
                    maxY = y;
                } else minY = y;

            }
            fixMinMax();
            if (!contains(x, y)) {
                System.out.println("Fail!");
            }
            return true;
        }
    }

    //Overload
    boolean add(Rectangle r) {
        return add(r.getMaxX(), r.getMaxY()) || add(r.getMinX(), r.getMinY());
    }

    private void fixMinMax() {
        if (minX > maxX) {
                int tempMinX = minX;
                minX = maxX;
                maxX = tempMinX;
            }
            if (minY > maxY) {
                int tempMinY = minY;
                minY = maxY;
                maxY = tempMinY;
            }
    }

//    Rectangle union(Rectangle r) { // TODO: 19.01.2016 debug for rect som ikke toucher tips
//        int x, y, X, Y;
//        if (Math.abs(maxX) > Math.abs(r.maxX))
//            X = maxX;
//        else
//            X = r.maxX;
//        if (Math.abs(maxY) > Math.abs(r.maxY))
//            Y = maxY;
//        else
//            Y = r.maxY;
//        if (Math.abs(minX) > Math.abs(r.minX))
//            x = minX;
//        else
//            x = r.minX;
//        if (Math.abs(minY) > Math.abs(r.minY))
//            y = minY;
//        else
//            y = r.minY;
//        return new Rectangle(x, y, X, Y);
//
//    }

    Rectangle union(Rectangle r) {
        Rectangle rect = new Rectangle(maxX, maxY, minX, minY);
        rect.add(r);
        return rect;
    }


//    boolean intersects(Rectangle rect) - returnerer true om dette rektanglet og rect-argumentet overlapper,
//    dvs. om det finnes ett eller flere punkter som er inneholdt i begge disse rektanglene.
    Boolean intersects(Rectangle r) {
        int X = r.getMaxX(), Y = r.getMaxY(), x = r.getMinX(), y = r.getMinY();
        int index1[] = {x, X, y, Y};
        int index2[] = {minX, maxX, minY, maxY};
        for (int i = 0;i < 4;i++) {
            boolean bool1 = contains(index1[i%2], index1[Math.floorDiv(i, 2)+2]);
            boolean bool2 = r.contains(index2[i%2], index2[Math.floorDiv(i, 2)+2]);
            if (bool1 || bool2) return true;
        }
        boolean bool = ((minY < y && maxY > Y) && (minX > x && maxX < X)) ||
                ((y < minY && Y > maxY) && (x > minX && X < maxX));
        return bool;
    }



//    Rectangle intersection(Rectangle rect) - returnerer et nytt
//    Rectangle-objekt som tilsvarer overlappet mellom dette rektanglet
//    og rect-argumentet. Alle punktene som finnes i begge rektanglene
//    skal alts� v�re inneholdt i rektanglet som returneres
    Rectangle intersection(Rectangle r) {

        int x, y, X, Y;
        if (Math.abs(maxX) < Math.abs(r.maxX))
            X = maxX;
        else
            X = r.maxX;
        if (Math.abs(maxY) < Math.abs(r.maxY))
            Y = maxY;
        else
            Y = r.maxY;
        if (Math.abs(minX) < Math.abs(r.minX))
            x = minX;
        else
            x = r.minX;
        if (Math.abs(minY) < Math.abs(r.minY))
            y = minY;
        else
            y = r.minY;
        return new Rectangle(x, y, X, Y);
    }

    @Override
    public String toString() {
        return String.format(
                "rect%5$d = Mangekant[(%1$d,%3$d),(%2$d,%3$d),(%2$d,%4$d),(%1$d,%4$d)]",
                getMinX(), getMaxX(), getMinY(), getMaxY(), NUM);
    }


    //============ Getters ====================
    public int getMinY() {
        return minY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getHeight() {
        return Math.abs(maxY-minY);
    }

    public int getWidth() {
        return Math.abs(maxX-minX);
    }
}
