package BinaryCI;

//import java.util.*;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {
    Iterator<Double> iterator1, iterator2;
    int index = 0;
    BinaryOperator operator;
    Double default1, default2;


    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
        this(iterator1, iterator2, null, null, operator);
    }

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.operator = operator;
        this.default1 = default1;
        this.default2 = default2;
    }



    @Override
    public boolean hasNext() {
        if (default1 == null && default2 == null) {
            return iterator1.hasNext() && iterator2.hasNext();
        } else if (default1 == null && !iterator1.hasNext() || default2 == null && !iterator2.hasNext()) {
            return false;
        } else
            return iterator1.hasNext() || iterator2.hasNext();
    }

    @Override
    public Double next() {
        Double i1, i2;
        i1 = iterator1.hasNext() ? iterator1.next():default1;
        i2 = iterator2.hasNext() ? iterator2.next():default2;
        return (Double) operator.apply(i1, i2);
    }


}
