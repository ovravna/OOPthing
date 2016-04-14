package AbstractAccount;

//import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class AbstractAccount{
    protected double balance;
    private static List<AbstractAccount> accounts = new ArrayList<>();
    private IllegalArgumentException negativeAmount = new IllegalArgumentException("Negative amount");

    public AbstractAccount() {
        this(0);
    }

    public AbstractAccount(double balance) {
        this.balance = balance;
        accounts.add(this);
    }

    public void deposit(double amount) {
        if (amount < 0) throw negativeAmount;
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw negativeAmount;
        internalWithdraw(amount);

    }

    protected abstract void internalWithdraw(double amount) ;

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Account type: %s \nBalance: %.2f NOK\n", this.getClass().getSimpleName(), balance);

    }
}
