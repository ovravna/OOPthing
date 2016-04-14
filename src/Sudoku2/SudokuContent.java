package Sudoku2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SudokuContent {
    private static Scanner input = new Scanner(System.in);

    private static void handleSpesials(String... strings) throws Undo, Load, Save, Redo, Done {
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
        List keys = Arrays.asList("q", "w", "e", "a", "s", "d", "z", "x", "c");
        List spesials = Arrays.asList("b", "undo", "redo", "save", "load", "exit");
        String boxString = "";
        String fieldString = "";
        int[] point = new int[2];
        do {
            if (!keys.contains(boxString)) {
                System.out.print("Choose box\ninput>");
                boxString = input.next();
            } else {
                System.out.print("Choose field\ninput>");
                fieldString = input.next();
            }
        } while (!((keys.contains(fieldString) && keys.contains(boxString)) || spesials.contains(fieldString) || spesials.contains(boxString)));
        handleSpesials(boxString, fieldString);

        int box = keys.indexOf(boxString);
        int field = keys.indexOf(fieldString);
        point[0] = 3*(int) (box/3.)+(int) (field/3.);
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
                System.out.print("Are you sure? y/n\ninput>");
            } while (!Arrays.asList("y", "n").contains(sure = input.next()));
            return sure.equals("y");
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




































