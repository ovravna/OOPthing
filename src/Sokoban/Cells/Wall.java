package Sokoban.Cells;

//import java.util.*;

public class Wall extends Cell {


    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public char getChar() {
        return '#';
    }

    @Override
    public boolean isMutable() {
        return false;
    }


}
