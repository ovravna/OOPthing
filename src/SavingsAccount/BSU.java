package SavingsAccount;


public class BSU extends SavingsAccount {
    private final double yearlyDeposit;
    private double depositedThisYear = 0;

    public BSU(double interestRate) {
        this(interestRate, 25_000D);
    }

    public BSU(double interestRate, double yearlyDeposit) {
        this(0, interestRate, yearlyDeposit);

    }

    public BSU(double balance, double interestRate, double yearlyDeposit) {
        super(balance, interestRate);
        this.yearlyDeposit = yearlyDeposit;
    }


    public double getTaxDeduction() {
        return depositedThisYear*0.2;
    }

    @Override
    public void deposit(double amount) {
        if (amount+depositedThisYear <= yearlyDeposit) {
            super.deposit(amount);
            depositedThisYear += amount;
        } else throw new IllegalStateException("You can't deposit that much cash");
    }

    @Override
    public void withdraw(double amount) {
        if (amount < depositedThisYear) {
            super.withdraw(amount);
            depositedThisYear -= amount;
        } else throw new IllegalStateException("You can't withdraw that much cash");
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        depositedThisYear = 0;

    }
}
