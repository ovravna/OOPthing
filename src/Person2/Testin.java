package Person2;

//import java.util.*;

import java.util.*;

public class Testin {
    public static void main(String[] args) {
        List<Integer> kake = new ArrayList<>(Arrays.asList(2, 4, 1, 5, 3));
        Iterator kakeIt = kake.iterator();
//        while (kakeIt.hasNext()) {
//            System.out.println(kakeIt.next());
//        }


//        for (int i = 0;i < kake.size();i++) {
//            System.out.println(kakeIt.next());
//        }
        for (int i = 0;i < kake.size();i++) {
            System.out.println(kake.get(i));
        }


//        System.out.println();
//        List<Integer> kake2 = kake.subList(1, kake.size()-1);
//
//        for (Object n : kake2.toArray()) {
//            System.out.println(n);
//        }
    }
}
