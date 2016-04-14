package Øving1;

public class Øving1 {
    public static void main(String[] args) {
        RPNCalc calc = new RPNCalc();
        calc.push(2);
//        calc.push(8);
//        calc.push(-3.2);
//        calc.performOperation('~');
//        calc.performOperation('p');
        calc.performOperation('+');

        System.out.println(calc);
    }
}
