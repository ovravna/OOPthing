package AbstractAccount;

//import java.util.*;

public class AbstractMain {
    public static void main(String[] args) {
        CreditAccount account = new CreditAccount(5000);
//        account.setCreditLine(3000);
        account.withdraw(4000);
        account.setCreditLine(3000);

        System.out.println(account);
    }
}
