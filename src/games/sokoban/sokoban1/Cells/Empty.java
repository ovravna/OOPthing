package games.sokoban.sokoban1.Cells;

public class Empty extends Cell {

    public Empty(int x, int y) {
        super(x, y);
    }

    @Override
    char getChar() {
        return ' ';
    }

    @Override
    boolean isMutable() {
        return true;
    }
}
