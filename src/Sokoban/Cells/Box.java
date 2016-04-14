package Sokoban.Cells;

//import java.util.*;

public class Box extends Cell {


    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public char getChar() {
        return '$';
    }

    @Override
    public boolean isMutable() {
        return true;
    }


}
