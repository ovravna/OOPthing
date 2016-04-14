package SavingsAccount;

//import java.util.*;

public class SavingsMain {
    public static void main(String[] args) {
        SavingsAccount bsu = new BSU(1000,0.05,100);
        SavingsAccount fspar = new ForeldreSpar(1000, 0.03, 2);

        bsu.deposit(90);
        fspar.withdraw(100);
        fspar.withdraw(10);
        SavingsAccount.staticEndYearUpdate();
        bsu.deposit(100);
        fspar.withdraw(10);
        bsu.endYearUpdate();


        System.out.println(bsu);
        System.out.println(fspar);

    }
}
