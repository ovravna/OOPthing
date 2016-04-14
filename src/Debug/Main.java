package Debug;

//import java.util.*;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Iterator i1 = Arrays.asList("ka", "ke").iterator();
        Iterator i2 = Arrays.asList("bo", "ll", "e").iterator();
        Iterator kake = new StringMergingIterator(i1, i2);
        while (kake.hasNext()) {
            System.out.println(kake.next());
        }
    }
}
