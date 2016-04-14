package Highscore;

//import java.util.*;

public class TimeMain{
    public static void main(String[] args) {

        int tall = 100_00;
        System.out.println(tall);
        HighscoreList list = new HighscoreList(tall);

        long t0 = System.nanoTime();
        for (int i = 0;i < tall;i++) {
            list.addResult(i);
        }
        long t1 = System.nanoTime();
        System.out.printf("%f s\n",(t1-t0)/Math.pow(10,9));
        for (int i = 0;i < tall;i++) {
            list.addHighscoreListListener(new Thing());
        }

        long t2 = System.nanoTime();
        System.out.printf("%f s\n", (t2-t1)/Math.pow(10, 9));
        list.addResult(tall+1);
        long t = System.nanoTime()-t2;
        System.out.printf("%f s\n", t/Math.pow(10, 9));



    }
}





class Thing implements HighscoreListListener {

    @Override
    public void listChanged(HighscoreList list, int i) {
        if (i != -1) try {
            throw new Pokemon("Pika!");
        } catch (Pokemon pokemon) {
            pokemon.printStackTrace();
        }

    }
}


class Pokemon extends Throwable {
    Pokemon(String s) {
        super(s);
    }
}