package Øving1;

import java.util.ArrayList;
import java.util.Date;

public class RPNCalc {
    ArrayList<Double> stack = new ArrayList<Double>();
    void push(double n) {
        stack.add(n);
    }

    double pop() {
        int index = stack.size()-1;
        if (index == -1) {
            return Double.NaN;
        }
        double returnNum = stack.get(index);
        stack.remove(index);
        return returnNum;
    }

    double peek(int i) {
        int index = stack.size()-1;
        if (index == -1) {
            return Double.NaN;
        }
        return stack.get(index-i);
    }

    int getSize() {
        return stack.size();
    }

    void performOperation(char c) {
        double num1 = this.pop();
        double num2 = this.pop();
        switch (c) {
            case '+':
                stack.add(num1+num2);
                break;
            case '-':
                stack.add(num2-num1);
                break;
            case '*':
                stack.add(num1*num2);
                break;
            case '/':
                stack.add(num2/num1);
                break;
            case '~':
                stack.add(num1);
                stack.add(num2);
                break;
            case 'p':
                stack.add(num2);
                stack.add(num1);
                stack.add(Math.PI);
                break;
            case '|':
                stack.add(num2);
                stack.add(Math.abs(num1));
                break;
            case '%':
                stack.add(num2%num1);
                break;
            default:
                System.out.println("Bad operator!");
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        for (double n:stack) {
            returnString += n + "\n";
        }
        return returnString;
    }
}












