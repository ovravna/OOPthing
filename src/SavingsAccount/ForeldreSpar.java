package SavingsAccount;


public class ForeldreSpar extends SavingsAccount{
    private final int legalWithdrawals;
    private int withdrawalsThisYear;

    public ForeldreSpar(double interestRate, int legalWithdrawals) {
        this(0, interestRate, legalWithdrawals);
    }

    public ForeldreSpar(double balance, double interestRate, int legalWithdrawals) {
        super(balance, interestRate);
        this.legalWithdrawals = legalWithdrawals;
    }


    public int getRemainingWithdrawals() {
        return legalWithdrawals-withdrawalsThisYear;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        withdrawalsThisYear = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawalsThisYear < legalWithdrawals) {
            super.withdraw(amount);
            withdrawalsThisYear++;
        } else throw new IllegalStateException("Too many withdrawals this year");
    }
}
