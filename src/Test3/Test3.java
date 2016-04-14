package Test3;


public class Test3 {
    int counter = 10;
    public static void main(String[] args) {
        UpOrDownCounter obj = new UpOrDownCounter(1,100,4);

        do {
            System.out.println(obj);
        } while(obj.count());
    }

    private int count() {
        counter++;
        return counter;
    }
}
