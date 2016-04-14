package Sokoban;

//import java.util.*;

import Sokoban.Cells.Cell;

import java.util.List;

public class MultipleCellException extends Exception {
    private List<Class> classes;
    private List<Cell> cells;

    public MultipleCellException(List list) {
        if (list.get(0) instanceof Cell) {
            this.cells = list;
        } else if (list.get(0) instanceof Class) {
            this.classes = list;
        } else throw new IllegalStateException("Bug at MultipleCellException");

    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Class> getClasses() {
        return classes;
    }
}
