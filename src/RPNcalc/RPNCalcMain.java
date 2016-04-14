package RPNcalc;

public class RPNCalcMain {
    public static void main(String[] args) {
        RPNCalc calc = new RPNCalc();
        RPNscanner rpn = new RPNscanner(calc);

        while (true) {
            rpn.Scan();
        }
    }
}



