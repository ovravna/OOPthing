package MathSpider;

//import java.util.*;

public class MathSpiderMain {
    public static void main(String[] args) {
        MathSpider mathSpider = new MathSpider();
        try {
            mathSpider.makePageCodeArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
