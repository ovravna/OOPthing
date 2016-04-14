package Test2;


public class Digit {
    int base, value;
    static int count;

    public Digit() {
        this(10);
    }

    public Digit(int base) {
        this.base = base;
        count++;
    }

    public int getValue() {
        return value;
    }

    public boolean increment() {
        return increment(1);
    }

    public boolean increment(int num) {
        int lastValue = value;
        value += num;
        value %= base;
        return lastValue+num != value;
    }

    @Override
    public String toString() {
        int rest,
            i = 0;
        if (value > 9) {
            rest = value-10;
            for (char c = 'A';c <= 'Z';c++) {
                if (rest == i) {
                    return ""+c;
                }
                i++;
            }
        }
        return ""+value;
    }
}
