package Highscore;

//import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Testin {

    public static void main(String... args) {

//        List<Integer> kake = Arrays.asList(3, 2, 3, 6, 7, 8, 42, 91);
//        kake.replaceAll(n -> n%2 == 0 ? n+1:n);
//        kake.sort((n, m) -> n%2 > m%2 ? 1:-1);
//
//        System.out.println(kake);
//        ArrayKake<Integer> kake = new ArrayKake<>();
//        kake.addAll(Arrays.asList(1, 2, 4, 2, 4, 2, 1, 2));
//        System.out.println(kake.count(2));
//
//
//        ArrayList<Integer> bolle = new ArrayList<Integer>() {
//            public int count(Integer n) {
//                List tempList = this;
//                for (int i = 0;i < tempList.size();i++) {
//                    if (tempList.get(i).equals(n)) tempList.remove(i);
//                }
//                return tempList.size();
//            }
//        };


        int i = 3;
        int a = 4;

        a = i + (i = a) - a;




        System.out.println(a+" "+i);






    }

    static void kake() {


    }


}

class ArrayKake<T> extends ArrayList<T> {
    public int count(T n) {
        List tempList = this;
        for (int i = 0;i < tempList.size();i++) {
            if (tempList.get(i).equals(n)) tempList.remove(i);
        }
        return tempList.size();
    }

}








