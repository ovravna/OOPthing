package Account2;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account(10, 1.03);
        account.deposit(10000000);
        account.withdraw(10000);
        account.addInterest();

        System.out.println(account);

    }
}
