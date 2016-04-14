package Test1;


public class Account {
    public static void main(String[] args) {
        int kake = 2;

        switch (kake) {
            case 0b10 | 0b10:
                System.out.println("kake");
        }


    }




//    private double balance = 0;
//    private double interestRate = 1.03;
//
//    void deposit(double amount) {
//        if (amount > 0) {
//            balance += amount;
//        }
//    }
//
//    void withdraw(double amount) {
//        balance -= Math.abs(amount);
//    }
//
//    void addInterest() {
//        balance *= interestRate;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("Current balance: %10.2f NOK\n", balance);
//    }
}
