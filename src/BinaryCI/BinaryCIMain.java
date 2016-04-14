package BinaryCI;

//import java.util.*;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinaryCIMain {
    public static void main(String[] args) {

        Iterator iterator1 = Arrays.asList(2.0, 3.0, 6.).iterator();
        Iterator iterator2 = Arrays.asList(5.0).iterator();
        Iterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, 5.,2., (x, y) -> x+y);

        List<Double> kake = Lists.newArrayList(binaryIterator);

        for (Double s : kake) {
            System.out.println(s);
        }



    }
}
