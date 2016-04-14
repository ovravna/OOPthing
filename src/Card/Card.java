package Card;


import java.util.Arrays;
import java.util.List;

public class Card{
    private char suit;
    private int face;
    private final List<Character> SUITS = Arrays.asList('S', 'H', 'D', 'C');


    public Card(char suit, int face) {
        if (SUITS.contains(suit) && face <= 13 && face >= 1) {
            this.suit = suit;
            this.face = face;
        } else throw new IllegalArgumentException("Nonexistent card");
    }

    public Card(int suit, int face) {
        if (suit >= 0 && suit <= 3 && face <= 13 && face >= 1) {
            this.suit = SUITS.get(suit);
            this.face = face;
        } else throw new IllegalArgumentException("Fakk all!");
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    public String getSuitName() {
        String[] suitNames = {"\u2660", "\u2665", "\u2666", "\u2663"};
        return suitNames[SUITS.indexOf(suit)];
    }

    @Override
    public String toString() {
        return String.format("%s%s",suit,getFaceName());
    }


    public String getFaceName() {
        String[] cards = {"J", "Q", "K"};
        if (face > 10) {
            return cards[face-11];
        } else if (face == 1) return "A";
        else return ""+face;


    }
}
