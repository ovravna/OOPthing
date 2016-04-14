package EqSolv;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;


public class EqInput {
    private static Scanner input = new Scanner(System.in);

    public static void userInput() {
        Equation eq = new Equation("eq");
        List<String> variables = new ArrayList<>();
        List<Equation> equations = new ArrayList<>();
        Pattern eqPattern = Pattern.compile("(?i)(([+\\-]?)\\s?(\\d*)([a-z]))|(?<==\\s?)([+\\-]?)\\s?(\\d+)?");
        String inputText = input.nextLine();
        Matcher eqMatch = eqPattern.matcher(inputText);
        while (eqMatch.find()) {
            String[] groups = new String[5];
            for (int i = 0;i < 5;i++) {
                if (eqMatch.group(i+2) != null) groups[i] = eqMatch.group(i+2);
                else if (i == 0 || i == 3) groups[i] = "";
                else if (eqMatch.group(4) != null) groups[1] = "1";
            }

            if (groups[1] != null && groups[2] != null) {
                if (!variables.contains(groups[2])) {
                    variables.add(groups[2]);
                    System.out.println(groups[0]+groups[1]);
                    equations.add(new Equation(groups[2], parseInt(groups[0]+groups[1])));
                } else {
                    int index = variables.indexOf(groups[2]);
                    equations.get(index).setValue(parseInt(groups[0]+groups[1]));
                }
            }

            if (groups[4] != null) {
                eq.setValue(parseInt(groups[3]+groups[4]));
            }


//            if (groups[1] != null) System.out.println("Val: "+  parseInt(groups[0]+groups[1]));
//            if (groups[2] != null) System.out.println("Var: "+ groups[2]);
//            if (groups[4] != null) System.out.println("Eq: "+ parseInt(groups[3]+groups[4]));
        }
        for (Equation e : equations) {
            System.out.println(e.getEqMatrix());
        }


    }
}


















