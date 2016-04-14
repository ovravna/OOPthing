package Sokoban.Cells;

//import java.util.*;

public class Player extends Cell {


    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    char getChar() {
        return '@';
    }

    @Override
    boolean isMutable() {
        return true;
    }
}
