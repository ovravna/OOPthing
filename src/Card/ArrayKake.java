package Card;

//import java.util.*;

import java.util.ArrayList;

public class ArrayKake<T> extends ArrayList<T> {
    T getLast() {
        return this.get(this.size()-1);
    }

    T removeLast() {
        return this.remove(this.size()-1);
    }
}


