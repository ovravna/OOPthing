package TicTacToe;

import java.util.*;
import java.util.regex.*;

public class TicTacToeProgram {
    public static int[] place(int n, String player) {
        String keys[], key;
        Scanner input = new Scanner(System.in);
        int index, x, y;
        String strX, strY;

        System.out.printf("%s\n", player);
        if (n <= 4) {
            if (n == 4) {
                keys = new String[]
                {"1", "2", "3", "4", "q", "w", "e", "r", "a", "s", "d", "f", "z", "x", "c", "v"};
            } else if (n == 3) {
                keys = new String[]{"q", "w", "e", "a", "s", "d", "z", "x", "c"};
            } else {
                keys = new String[]{"q", "w", "a", "s"};
            }
            do {
                System.out.print("Place: ");
                key = input.next();
            } while (!Arrays.asList(keys).contains(key) || (n == 1 && !key.equals("q")));
            index = Arrays.asList(keys).indexOf(key);
            x = Math.floorDiv(index, n);
            y = index%n;
        } else {
            do {
                System.out.print("Choose line: ");
                strX = input.next();
                x = findInt(strX)-1;
                } while (x >= n || x < 0);
            do {
                System.out.printf("Place on line %s: ",x+1);
                strY = input.next();
                y = findInt(strY)-1;
            } while (y >= n || y < 0);
        }
        return new int[]{x, y};
    }

    public static int findInt(String str) {
        Pattern pat = Pattern.compile("\\d+");

        Matcher matcher = pat.matcher(str);
                if (matcher.find()) {
                    return Integer.parseInt(matcher.group());
                } else return -1;
    }

    public static void name(String[] names) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter 0 to cancel.");
        for (int i = 0;i < names.length;i++) {
            System.out.printf("Enter name of player %d:  ", i+1);
            String name = input.next();
            if (name.equals("0")) {
                break;
            } else
                names[i] = name;
        }
    }

    public static boolean continues(int[] score, String[] names) {
        Scanner input = new Scanner(System.in);
        String again = input.next();
        if (again.equals("0") || again.equals("no")) {
            System.out.println("Score: ");
            for (int i = 0;i < score.length;i++) {
                if (names[i] == null) {
                    names[i] = "Player "+(i+1);
                }
                System.out.printf("%-10s : %2d\n", (names[i]), score[i]);
            }
            return false;
        } else
            return true;
    }
}




















