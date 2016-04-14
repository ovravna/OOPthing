package Sokoban.Cells;

import Sokoban.CellListener;
import Sokoban.MultipleCellException;
import Sokoban.Point;
import games.sokoban.sokoban1.ISokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Cell{
    private Point position;


    public static List<Cell> gridElements = new ArrayList<>();
    protected static List<CellListener> listeners = new ArrayList<>();

    public Cell(int x, int y) {
        listeners.forEach(n -> n.addCell(this));
        gridElements.add(this);
        position = Point.valueOf(x, y);
    }


    public static Cell getCell(Point point) throws MultipleCellException {
        return getCell(point.getX(), point.getY());
    }

    public static Cell getCell(int x, int y) throws MultipleCellException{
        List<Cell> list = gridElements.stream().filter(cell -> cell.getPosition().equals(x, y)).collect(Collectors.toList());
        if (list.isEmpty()) return null;
        if (list.size() == 1) return list.get(0);
        list.sort((n,m) -> n.compereTo(m));
        throw new MultipleCellException(list);
    }


    public static char getCharAt(int x, int y) {
        List<Cell> list = gridElements.stream().filter(cell -> cell.getPosition().equals(x, y)).collect(Collectors.toList());
        if (list.isEmpty()) return ' ';
        if (list.size() == 1) return list.get(0).getChar();
        else {
            list.sort((n, m) -> n.compereTo(m));
            if (list.get(0) instanceof Player) {
                return '+';
            } else return '*';
        }

    }

    public int compereTo(Cell that) {

        if (this.isMutable() && that.isMutable()) return 0;
        if (this.isMutable() && !that.isMutable()) return -1;
        if (!this.isMutable() && that.isMutable()) return 1;
        else return 0;

    }


    public void setPosition(Point point) {
        setPosition(point.getX(), point.getY());
    }

    public void setPosition(Integer x, Integer y) {
        if (!this.isMutable()) throw new IllegalArgumentException("Cant change position of this cell");
        position.setPosition(x, y);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Point getPosition() {
        return position;
    }


    public static void addCellListener(CellListener listener) {
        listeners.add(listener);
    }

    public int getStaticCellValue() {
        if (this instanceof Wall) {
            return ISokoban.CELL_STATIC_WALL;
        } else if (this instanceof Goal) {
            return ISokoban.CELL_STATIC_TARGET;
        } else return ISokoban.CELL_STATIC_EMPTY;
    }

    public int getDynamicCellValue() {
        if (this instanceof Player) {
            return ISokoban.CELL_DYNAMIC_PLAYER;
        } else if (this instanceof Box) {
            return ISokoban.CELL_DYNAMIC_BOX;
        } else return ISokoban.CELL_DYNAMIC_EMPTY;
    }




    abstract char getChar();

    abstract boolean isMutable();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static int isLeft() {
        int r = 0;
        for (Cell cell : gridElements) {
            if (cell instanceof Goal) {
                try {
                    Cell.getCell(cell.getPosition());
                    r++;
                } catch (MultipleCellException e) {
                    if (e.getCells().get(0) instanceof Player) {
                        r++;
                    }
                }
            }
        }
        return r;
    }


    public static boolean playable() {
        int players = 0;
        int boxes = 0;
        int goals = 0;


        for (Cell cell : gridElements) {
            if (cell instanceof Player) {
                players++;
            } else if (cell instanceof Box) {
                boxes++;
            } else if (cell instanceof Goal) {
                goals++;
            }
        }

        return players == 1 && boxes == goals;


    }


    /**
     * Mainly for lolz
     */
    public void disappear() {
        this.position = Point.valueOf(null, null);
        gridElements.remove(this);
    }
}
