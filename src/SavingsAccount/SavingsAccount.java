package SavingsAccount;

import java.util.*;

public class SavingsAccount implements Account {
    private static List<SavingsAccount> accounts = new ArrayList<>();
    protected double balance;
    protected double interestRate;
    private IllegalArgumentException negativeAmount = new IllegalArgumentException("Negative amount");


    public SavingsAccount(double interestRate) {
        this(0, interestRate);
    }

    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        accounts.add(this);
    }

    protected void endYearUpdate() {
        balance *= 1+interestRate;
    }

    public static void staticEndYearUpdate() {
        for (SavingsAccount account : accounts) {
            account.endYearUpdate();
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) throw negativeAmount;
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) throw negativeAmount;
        if (amount > balance) throw new IllegalStateException("Too few cashz");
        balance -= amount;

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Account type: %s \nBalance: %.2f NOK\n", this.getClass().getSimpleName(), balance);
    }

}
