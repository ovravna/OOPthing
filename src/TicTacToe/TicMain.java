package TicTacToe;


public class TicMain {
    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe("retard");

        do {
            do {
                System.out.println(toe);
            } while (!toe.finished(toe.place()));
        } while (TicTacToeProgram.continues(toe.clear(),toe.getNames()));
    }
}
