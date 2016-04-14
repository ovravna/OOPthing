package Highscore;

import java.util.Scanner;

public class HighscoreProgram implements HighscoreListListener {
    private HighscoreList highscores;

    public static void main(String[] args) {

        HighscoreProgram main = new HighscoreProgram();


        main.init();
        while (main.run()) {
            System.out.println(main.highscores);
        }

    }


    private void init() {
        highscores = new HighscoreList(3, this);
    }

    private boolean run() {
        Scanner input = new Scanner(System.in);
        int result;
        String s;
        do {
            s = input.next();
            if (s.equals("stop")) return false;
            if (s.matches("-?\\d+")) break;
            else System.err.println("Not an integer value. Try again.");
        } while (true);

        result = new Integer(s);
        highscores.addResult(result);
        return true;
    }




    @Override
    public void listChanged(HighscoreList list, int i) {
        for (int j = 0;j < list.size();j++) {
            System.out.printf("Rank %2d: %3d\n", j+1, list.getElement(j));
        }
        System.out.printf("Changed at index %d\n\n",i);

    }

    @Override
    public String toString() {
        String r = "";

        while (highscores.hasNext()) {
            r += highscores.next()+"\n";
        }
        return r;
    }
}
