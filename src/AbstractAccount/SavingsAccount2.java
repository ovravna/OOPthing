package AbstractAccount;

//import java.util.*;

public class SavingsAccount2 extends AbstractAccount {
    private int withdrawals;
    private double fee;
    private int withdrawCounter = 0;

    public SavingsAccount2(int withdrawals, double fee) {
        this.withdrawals = withdrawals;
        this.fee = fee;
    }

    public SavingsAccount2(double balance, int withdrawals, double fee) {
        super(balance);
        this.withdrawals = withdrawals;
        this.fee = fee;
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Too few cashz!");
        } else if (withdrawals-withdrawCounter > 0) {
            withdrawCounter++;
            balance -= amount;
        } else if (amount+fee <= balance) {
            balance -= amount+fee;
        } else throw new IllegalStateException("Too few cashz!");


    }
}
