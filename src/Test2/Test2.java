package Test2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        int base = 16;

        Digit   dig0 = new Digit(base),
                dig1 = new Digit(base),
                dig2 = new Digit(base);
        for (int i = 0; i < Math.pow(base,Digit.count); i++) {
            String text = String.format("%s%s%s", dig2.value == 0 ? " ":dig2,
                    dig1.value == 0 && dig2.value == 0 ? " ":dig1, dig0);
            System.out.println(text);

            if (dig0.increment()) {
                if (dig1.increment()) {
                    dig2.increment();
                }
            }
        }
    }
}
