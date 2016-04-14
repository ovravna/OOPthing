package Account2;

import java.util.Locale;

public class Account {
    private double balance;
    private double interestRate;

    public Account(double balance, double interestProcent){
        if (balance < 0 || interestProcent  < 0) throw new IllegalArgumentException("One or more of the inputs are negative");
        this.balance = balance;
        this.interestRate = interestProcent/100.+1.;
    }

    void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Negative Amount");
        balance += amount;

    }

    void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Negative Amount");
        if (amount > balance) throw new IllegalStateException("Amount larger than balance");
        balance -=  amount;
    }

    void addInterest() {
        balance *= interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) throw new IllegalArgumentException("Negative Intrestrate");
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Current balance: %10.2f NOK\n", balance);
    }

}