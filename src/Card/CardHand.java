package Card;

//import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
    private List<Card> hand = new ArrayList<>();

    public int getCardCount() {
        return hand.size();
    }

    public Card getCard(int i) {
        try {
            return hand.get(i);
        } catch (Exception e) {
            throw new IllegalArgumentException("Fail!");
        }
    }


    public void addCard(Card card) {
        hand.add(card);
    }

    Card play(int n) {
        return hand.remove(n);
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0;i < hand.size();i++) {
            r += String.format(" _______\t");
        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|%-2s     |\t", hand.get(i).getFaceName());
        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|%-2s     |\t", hand.get(i).getSuitName());

        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|       |\t");
        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|     %2s|\t", hand.get(i).getSuitName());
        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|     %2s|\t", hand.get(i).getFaceName());
        }
        r += "\n";
        for (int i = 0;i < hand.size();i++) {
            r += String.format("|_______|\t");
        }
        return r;
    }

}
