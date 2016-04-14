package SuDoKu;

import java.util.*;
public class SudokuContent {
    private static Scanner input = new Scanner(System.in);

    private static final List KEYS = Arrays.asList("q", "w", "e", "a", "s", "d", "z", "x", "c");
    private static final List EXEPTIONS = Arrays.asList("b", "undo", "redo", "save", "load", "exit");

    public static final String INFO = "\n\n\n\n\n\n\n\n\n"+
            "\t\tS U D O K U\n"+
            "\tChoose position with\n\t\t   Q W E\n\t\t   A S D\n\t\t   Z X C\n\t\t" +
            "Operations:\n\tundo\tredo\tb (back)\n\tsave\tload\texit";


    private static void handleExeptions(String... strings) throws Undo, Load, Save, Redo, Done {
        for (String s:strings) {
            switch (s) {
                case "b":
                    setPosition();
                    break;
                case "undo":
                    throw new Undo();
                case "redo":
                    throw new Redo();
                case "save":
                    throw new Save();
                case "load":
                    throw new Load();
                case "exit":
                    throw new Done(false);
            }
        }
    }

    public static int[] setPosition() throws Save, Load, Redo, Undo, Done {
        String boxString = "";
        String fieldString = "";
        int[] point = new int[2];
        do {
            if (!KEYS.contains(boxString)) {
                System.out.print("Choose box\ninput>");
                boxString = input.next();
            } else {
                System.out.print("Choose field\ninput>");
                fieldString = input.next();
            }
        } while (!((KEYS.contains(fieldString) && KEYS.contains(boxString)) ||
                EXEPTIONS.contains(fieldString) || EXEPTIONS.contains(boxString)));
        handleExeptions(boxString, fieldString);

        int box = KEYS.indexOf(boxString);
        int field = KEYS.indexOf(fieldString);
        point[0] = 3*(box/3)+(field/3);
        point[1] = 3*(box%3)+(field%3);
        return point;
    }

    public static int setValue() {
        String s;
        do {
            System.out.print("Choose value\ninput>");
        } while (!(s = input.next()).matches("\\d"));
        return Integer.parseInt(s);
    }

    public static boolean isSure(int isError) {
        if (isError == 1) return true;
        else if (isError == 2) return false;
        else {
            String sure;
            do {
                System.out.print("Are you sure? y/N\ninput>");
            } while (!Arrays.asList("y", "n").contains(sure = input.next()));
            return sure.equalsIgnoreCase("y");
        }
    }
}


class Undo extends Throwable {

}

class Redo extends Throwable {

}

class Save extends Throwable {

}

class Load extends Throwable {

}




































