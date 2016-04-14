package games.sokoban.sokoban1.Cells;

//import java.util.*;



public class Goal extends Cell {


    public Goal(int x, int y) {
        super(x, y);
    }


    @Override
    public char getChar() {
        return '.';
    }

    @Override
    public boolean isMutable() {
        return false;
    }
}
