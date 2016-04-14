package Test1;

public enum Tester {
    KAKE, BOLLE, PUDDING, KJØTTDEIG;

    static {
        System.out.println("\nninja");
    }


    Tester() {
        stuff();
    }

    void stuff() {
        System.out.println("bolle!");
    }

    static void thing() {
        System.out.println("kake!");
    }


}
