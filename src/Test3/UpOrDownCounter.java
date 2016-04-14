package Test3;

public class UpOrDownCounter {
    int counter, end, jump = 1;

    public UpOrDownCounter(int end) {
        this.end = end;
    }

        public UpOrDownCounter(int start, int end) throws IllegalArgumentException{
            if(start == end) {
                throw new IllegalAccessError("Start and end value are the same.");
            } else {
                this.counter = start;
                this.end = end;
            }
        }
        public UpOrDownCounter(int start, int end, int jump) throws IllegalArgumentException {
            if(start == end || jump == 0) {
                throw new IllegalAccessError(
                        (jump == 0) ? "Invalid argument.":"Start and end value are the same.");
            } else if(jump < 0) {
                this.counter = end;
                this.end = start;
                this.jump = -jump;
            } else {
                this.counter = start;
                this.end = end;
                this.jump = jump;
            }
    }

    public int getCounter() {
        return counter;
    }

    boolean count() {
        if (end < counter) {
            counter -= jump;
            return counter > end;
        }
        else if (end > counter) {
            counter += jump;
            return counter < end;
        } else return false;
    }

    @Override
    public String toString() {
        return ""+counter;
    }
}
