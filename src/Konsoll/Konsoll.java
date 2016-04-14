package Konsoll;

import Person.Person;
import RPNcalc.RPNCalc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Konsoll {
    private RPNcalc.RPNCalc calc;
    private Person person;
    private String init = "";
    public Konsoll() {
        calc = new RPNCalc();
        person = new Person();

    }

    public void Scan() {
        Scanner input = new Scanner(System.in);
        String command, value;
        Pattern operatorPattern = Pattern.compile(".+(\\s.*)?");
        System.out.print("input>");

        String operation = input.nextLine();
        Matcher match = operatorPattern.matcher(operation);
        if (match.find()) {
            if (match.group().contains(" ")) {
                String[] commands = match.group().split(" ",2);
                command = commands[0];
                value = commands[1];
            } else {
                command = match.group();
                value = "\0";
            }
        } else {
            System.err.println("Invalid operation");
            return;
        }

        if (command.equals("init")) {
                init = value;
            return;
        } else if (init.isEmpty() && !command.equals("init")) {
            System.err.println("Program is not initialized");
            return;
        }

        switch (init) {
            case "rpn":
                runRpn(command, value);
                return;
            case "person":;
                runPerson(command, value);
                return;
            case "kake":
                System.out.println("kake!");
                return;
            default:
                System.err.println("Program does not exist");
                return;
        }
    }

    private void runPerson(String command, String value) {
        switch (command) {
            case "name":
                try {
                    person.setName(value);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "birthday":
                Matcher dateMatch = Pattern.compile("\\d\\d\\.\\d\\d\\.\\d\\d").matcher(value);
                if (dateMatch.find()) {
                    String[] dates = value.split("\\.");
                    int[] intDates = new int[3];
                    for (int i = 0;i < 3;i++) {
                        intDates[i] = Integer.parseInt(dates[i]);
                    }
                    person.setDateOfBirthday(intDates);
                } else {
                    System.err.println("Invalid date");
                }
                break;
            case "print":
            case "pritn":
                if (value != "\0") {
                    System.err.println("Redundant value");
                    return;
                } else System.out.print(person);
                break;
            case "gender":
                try {
                    if (value.length() != 1) throw new Exception("Char expected");
                    person.setGender(Character.toUpperCase(value.charAt(0)));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "snn":
                try {
                    person.setSNN(value);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "mail":
                try {
                    person.setEmail(value);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;

            default:
                System.err.println("Nonexisten operator");
                return;
        }
    }

    private void runRpn(String command, String value) {
        double numValue;
        boolean prefix = true;
        Matcher rpnMatch = Pattern.compile("([+-]?[0-9]+\\.?[0-9]*)|([-+~*/ps|%])|").matcher(value);
        if (!rpnMatch.find()) {
            System.err.println("Invalid value");
            return;
        }

        if ((value.charAt(0) == '+' || value.charAt(0) == '-') && !command.equals("perform")) {
            prefix = value.charAt(0) == '+';
            value = value.substring(1);
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
            case "pritn":
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
            case "clear":
                if (value != "\0") {
                    System.err.println("Redundant value");
                    return;
                } else calc.clear();
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


