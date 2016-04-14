package RPNcalc;

import java.util.*;
import java.util.regex.*;

public class RPNscanner {
    RPNCalc calc;
    public RPNscanner(RPNCalc calc) {
        this.calc = calc;
    }

    public void Scan() {
        Scanner input = new Scanner(System.in);
        String command, value;
        double numValue;
        boolean prefix = true;
        Pattern operatorPattern = Pattern.compile("[a-z]+(\\s(([+-]?[0-9]+\\.?[0-9]*)|([-+~*/ps|%])))?");
        System.out.print("input>");

        String operation = input.nextLine();
        Matcher match = operatorPattern.matcher(operation);
        if (match.find()) {
            if (match.group().contains(" ")) {
                String[] commands = match.group().split(" ");
                command = commands[0];
                value = commands[1];
                if ((value.charAt(0) == '+' || value.charAt(0) == '-') && !command.equals("perform")) {
                    prefix = value.charAt(0) == '+';
                    value = value.substring(1);
                }
            } else {
                command = match.group();
                value = "\0";
            }
        } else {
            System.err.println("Invalid operation");
            return;
        }

        if (value.contains(".")) {
            numValue = Double.parseDouble(value);
        } else if (isInteger(value)) {
            numValue = Integer.parseInt(value);
        } else {
            if (value.length() != 1) {
                System.err.println("Invalid value");
                return;
            } else numValue = (int) value.charAt(0);
        }
        numValue = prefix ? numValue:-numValue;
        switch (command) {
            case "push":
            case "poke":
            case "add":
                calc.push(numValue);
                break;
            case "pop":
                if (value != "\0") {
                    System.err.println("Redundant value");
                    return;
                } else System.out.println(calc.pop());;
                break;
            case "peek":
                Double num = calc.peek((int) numValue);
                System.out.print(!num.equals(Double.NaN) ? num+"\n":"");
                break;
            case "perform":
                calc.performOperation((char) numValue);
                break;
            case "print":
            case "stack":
                if (value != "\0") {
                    System.err.println("Redundant value");
                    return;
                } else System.out.print(calc);
                break;
            case "size":
                if (value != "\0") {
                    System.err.println("Redundant value");
                    return;
                } else System.out.println(calc.getSize());
                break;
            default:
                System.err.println("Nonexisten operator");
                return;
        }


    }

    private boolean isInteger(String s) {
        for (int i = 0;i < s.length();i++) {
            int charVal = (int) s.charAt(i);
            if (charVal > 57 || charVal < 48) {
                return false;
            }
        }
        return true;


    }
}

