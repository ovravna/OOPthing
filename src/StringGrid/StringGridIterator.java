package StringGrid;

//import java.util.*;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
    private int row = 0, col = 0;
    StringGrid grid;
    boolean colMajor;


    public StringGridIterator(StringGrid grid, boolean rowMajor) {
        this.grid = grid;
        this.colMajor = !rowMajor;
    }

    public boolean hasNext() {
        try {
            grid.getElement(row, col);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String next() {
        String s = grid.getElement(row, col);
        int[] coor = isNext(row, col);
        this.row = coor[0];
        this.col = coor[1];
        return s;
    }

    private int[] isNext(int row, int col) {
        if (colMajor) {
            row = (row+1)%grid.getRowCount();
            col = col+(row == 0 ? 1:0);
        } else {
            col = (col+1)%grid.getColumnCount();
            row = row+(col == 0 ? 1:0);
        }
        return new int[]{row, col};
    }

    public void remove() {
        throw new UnsupportedOperationException("Haha fail!");
    }
}
