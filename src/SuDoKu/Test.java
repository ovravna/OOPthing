package SuDoKu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//    List<Integer> states = new ArrayList<>();
//    List<Integer> undoneStates = new ArrayList<>();

    public boolean kake;

    public Test() {
        kake = false;
    }

    public static void main(String[] args) {
        String kake = "hei det er kult";
        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher(kake);

//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }

        matcher.find();

    }


}



class Bolle extends Test {

    public Bolle() {
        kake = true;
    }
}

