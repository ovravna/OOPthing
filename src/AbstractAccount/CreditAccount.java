package AbstractAccount;

//import java.util.*;

public class CreditAccount extends AbstractAccount {
    private double creditLine;

    public CreditAccount(double creditLine) {
        this(0, creditLine);
    }

    public CreditAccount(double balance, double creditLine) {
        super(balance);
        setCreditLine(creditLine);
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        if (creditLine < 0) throw new IllegalArgumentException();
        if (creditLine+balance < 0) throw new IllegalStateException("Kake!");
        this.creditLine = creditLine;
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (amount > balance+creditLine) {
            throw new IllegalStateException("Too litle cashz");
        } else balance -= amount;
    }


}
