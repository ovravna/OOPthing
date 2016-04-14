package AbstractAccount;

//import java.util.*;

public class DebitAccount extends AbstractAccount {

    public DebitAccount() {
    }

    public DebitAccount(double balance) {
        super(balance);
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (amount > balance) throw new IllegalStateException("Too few cashz!");
        else balance -= amount;
    }
}
