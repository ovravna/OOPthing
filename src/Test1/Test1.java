package Test1;

public class Test1 {
    public static void main(String... args) {


        System.out.println("kake");
        System.out.println(args[0]);


        for (int i = 0;i < 10;i++) {
            System.out.println(i);
            if (i == 7) {
                System.exit(0);
            }
        }

    }
}
