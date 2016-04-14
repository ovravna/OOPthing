package StringGrid;

//import java.util.*;

public interface StringGrid extends Iterable<String>{
    int getRowCount();
    int getColumnCount();
    String getElement(int row, int column);
    void setElement(int row, int column, String element);

    default void kake() {
        System.out.println("kake!");
    }

}
