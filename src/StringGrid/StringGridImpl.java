package StringGrid;

//import java.util.*;

import java.util.Iterator;

public class StringGridImpl implements StringGrid {
    String[][] stringGrid;


    public StringGridImpl(int rows, int columnCount) {
        stringGrid = new String[columnCount][rows];
    }

    @Override
    public int getRowCount() {
        return stringGrid[0].length;
    }

    @Override
    public int getColumnCount() {
        return stringGrid.length;
    }

    @Override
    public String getElement(int row, int column) {
        try {
            return stringGrid[column][row];
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    @Override
    public void setElement(int row, int column, String element) {
        try {
            stringGrid[column][row] = element;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid index");
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new StringGridIterator(this, true);
    }

    @Override
    public String toString() {
        Iterator it = this.iterator();
        String s = "";

        for (int i = 0;it.hasNext();i++) {
            if (i%stringGrid.length == Math.floorMod(-1, stringGrid.length)) {
                s += it.next()+"\n";
            } else s += it.next()+" ";
        }


        return s;
    }
}
