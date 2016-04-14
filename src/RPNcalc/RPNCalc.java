package RPNcalc;


import java.util.ArrayList;

public class RPNCalc {
    private ArrayList<Double> stack = new ArrayList<Double>();

    public void push(double n) {
        stack.add(n);
    }

    public double pop() {
        int index = stack.size()-1;
        if (index == -1) {
            System.err.println("Empty stack error");
        }
        double returnNum = stack.get(index);
        stack.remove(index);
        return returnNum;
    }

    public double peek(int i) {
        int index = stack.size()-1;

        if (i > index || i < 0) {
            System.err.println("Index error");
            return Double.NaN;
        } else return stack.get(index-i);
    }

    public void clear() {
        stack = new ArrayList<Double>();
    }
    public int getSize() {
        return stack.size();
    }

    public void performOperation(char c) {
        double num1 = 0, num2 = 0;
        if (getSize() == 1) {
            num1 = this.pop();
            num2 = (c == '*' || c == '/') ? 1.:0.;
        } else if (c != 'p'){
            num1 = this.pop();
            num2 = this.pop();
        }

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
            case 's':
                if (getSize() == 1) break;
                stack.add(num1);
                stack.add(num2);
                break;
            case 'p':
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
                System.err.println("Bad operator!");
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
