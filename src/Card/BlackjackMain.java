package Card;

//import java.util.*;

public class BlackjackMain {
    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        do {
            System.out.println((bj.play() > bj.playDealer()) ? "You won!\n":"You lost!\n");
            System.out.println("\n\n\n\n");
        } while (true);
    }
}
