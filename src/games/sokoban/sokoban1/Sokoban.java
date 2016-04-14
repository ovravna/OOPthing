package games.sokoban.sokoban1;

import SuDoKu.GridListener;
import SuDoKu.ObserableGrid;
import games.sokoban.sokoban1.Cells.*;

import java.util.*;


public class Sokoban implements ISokoban, ObserableGrid {
    private List<List<Boolean>> frame = new ArrayList<>();

    private List<GridListener> listeners = new ArrayList<>();

    static String s = "#######\n"+
            "#.@ # #\n"+
            "#$* $ ##########\n"+
            "#  $  #  .  $  #\n"+
            "# ..  #        #\n"+

            "#  *  ###### ###\n"+
            "#######";
    static String y = "#..$    @$#";


    static String k = "#######|#.@ # #|#$* $ #|#   $ #|# ..  #|#  *  #|#######";
    static String q =
            "#######\n"+
            "#.  # #\n"+
            "#$* $ #\n"+
            "#  $@ #\n"+
            "# ..  #\n"+
            "#  *  #\n"+
            "#######";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Sokoban sokoban = new Sokoban();
        sokoban.init(q);
        Map<String, Point> charMap = new HashMap<>();
        charMap.put("w", Point.UP);
        charMap.put("s", Point.DOWN);
        charMap.put("a", Point.LEFT);
        charMap.put("d", Point.RIGHT);
        String s;
        do {
            System.out.println(sokoban);
            do {
            } while (!charMap.containsKey(s = input.next()));
        } while (sokoban.move(charMap.get(s)));
    }


    @Override
    public void init(String level) {
        int x = 0, y = 0;
        frame = new ArrayList<>();
        frame.add(new ArrayList<>());
        Cell.resetCells();

        for (char cell : level.toCharArray()) {


            switch (cell) {
                case '\n':
                case '|':
                    frame.add(new ArrayList<>());
                    x++;
                    y = 0;
                    continue;
                case ' ':
                    //new Empty(x, y);
                    break;
                case '#':
                    new Wall(x, y);
                    break;
                case '.':
                    new Goal(x, y);
                    break;
                case '@':
                    new Player(x, y);
                    break;
                case '$':
                    new Box(x, y);
                    break;
                case '*':
                    new Box(x, y);
                    new Goal(x, y);
                    break;
                case '+':
                    new Player(x, y);
                    new Goal(x, y);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("%s not allowed", cell));
            }
            frame.get(x).add(false);
            y++;
        }
//        if (!Cell.playable()) {
//            throw new IllegalStateException("Unplayable game");
//        }
    }

    @Override
    public int getWidth() {
        return frame.get(0).size();
    }

    @Override
    public int getHeight() {
        return frame.size();
    }

    @Override
    public int getStaticCellValue(int x, int y) {
        try {
            return Cell.getCell(x, y) != null ? Cell.getCell(x, y).getStaticCellValue():0;
        } catch (MultipleCellException e) {
            return 1;
        }
    }

    @Override
    public int getDynamicCellValue(int x, int y) {
        try {
            return Cell.getCell(x, y).getDynamicCellValue();
        } catch (MultipleCellException e) {
            return e.getCells().get(0).getDynamicCellValue();
        } catch (NullPointerException c) {
            return ISokoban.CELL_DYNAMIC_EMPTY;
        }
    }

    @Override
    public int countCells(Integer cellStatic, Integer cellDynamic) {
        int count = 0;
        for (Cell cell : Cell.gridElements) {
            if (cell.getDynamicCellValue() == cellDynamic && cell.getStaticCellValue() == cellStatic) {
                count++;
            }
        }
        return count;
    }

    private Player player() {
        for (Cell cell : Cell.gridElements) {
            if (cell instanceof Player) return ((Player) cell);
        }
        throw new IllegalStateException("No player");

    }

    public boolean move(Point point) {
        return move(point.getX(), point.getY());
    }

    public boolean move(int x, int y) {
        Boolean moved = movePlayer(x, y);

        if (moved == null) {
            System.err.println("Illegal move");
        }

        return true;

    }

    @Override
    public Boolean movePlayer(int dx, int dy) {
        Point direction = Point.valueOf(dx, dy);
        Player player = player();
        Point playerPos = player.getPosition();
        Point movePos = playerPos.add(direction);

        Cell dCell;

        try {
            dCell = Cell.getCell(movePos);
        } catch (MultipleCellException e) {
            dCell = e.getCells().get(0);
        }


        if (dCell == null || dCell instanceof Goal) {
            player.setPosition(movePos);
            return false;
        } else if (dCell instanceof Wall) {
            return null;
        } else if (dCell instanceof Box) {
            boolean wasPushed = pushBox((Box) dCell, direction);
            if (wasPushed) {
                player.setPosition(movePos);
                return true;
            } else {
                return null;
            }
        } else throw new IllegalStateException("Don't know...");
    }

    private boolean pushBox(Box box, Point direction) {
        Point pushPoint = box.getPosition().add(direction);
        Cell pushCell;

        try {
            pushCell = Cell.getCell(pushPoint);
        } catch (MultipleCellException e) {
            return false;
        }

        if (pushCell == null || pushCell instanceof Goal) {
            box.setPosition(pushPoint);
            System.out.println(Cell.isLeft());
            if (Cell.isLeft() == 1) {
                try {
                    Cell c = Cell.getCell(3, 6);
                    if (c != null) {
                        System.err.println("Poof!");
                        Cell.getCell(3, 6).disappear();
                    } else if (pushCell instanceof Goal) {
                        new Wall(3, 6);
                    }
                } catch (MultipleCellException e) {
                    e.printStackTrace();
                }
            } else if (Cell.isLeft() == 0) {
                System.err.println("You won!");
                new Wall(3, 6);
            }




            return true;
        } else if (pushCell instanceof Wall || pushCell instanceof Box) {
            return false;
        } else throw new IllegalStateException("Still don't know...");
    }


    @Override
    public String toString() {
        String r = "";
        for (int x = 0;x < frame.size();x++) {
            for (int y = 0;y < frame.get(x).size();y++) {
                r += Cell.getCharAt(x, y);
            }
            r += "\n";
        }
        return r;
    }


    @Override
    public void addGridListener(GridListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeGridListener(GridListener listener) {
        listeners.remove(listener);
    }
}