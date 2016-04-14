package Card;

import java.util.*;

public class Blackjack {
    private CardDeck deck;

    public Blackjack() {
        newDeck();
    }

    private void newDeck() {
        deck = new CardDeck(new CardDeck(13), new CardDeck(13), new CardDeck(13));
        deck.shuffle();
//        deck.shufflePerfectly();
//        deck.shuffle();
    }



    public void deal(CardHand player,int n) {
        try {
            deck.deal(player, n);
        } catch (Exception e) {
            System.err.println("Shuffeling...");
            newDeck();
            deck.deal(player, n);
        }
    }

    private boolean isFine(CardHand hand) {
        return valueOfHand(hand) <= 21;
    }


    public int play() {
        CardHand player = new CardHand();
        Scanner input = new Scanner(System.in);
        deal(player, 2);
        while (isFine(player)) {
            System.out.println(player);
            System.out.println("Hit [h]\nStand [s]");
            if (valueOfHand(player) != 21 && input.next().equals("h")) {
                deal(player, 1);
            } else if (valueOfHand(player) == 21 && !input.next().equals("µ")) break;
            else break;
        }
        System.out.println(player);
        System.out.println(isFine(player) ? "":"You failed!");
        return (isFine(player)) ? valueOfHand(player):0;
    }

    public int playDealer() {
        CardHand dealer = new CardHand();
        deal(dealer, 2);
        while (isFine(dealer)) {
            if (valueOfHand(dealer) < 17) {
                deal(dealer, 1);
            } else break;
        }
        System.out.println("\nDealers hand:");
        System.out.println(dealer);
        System.out.printf("Dealer got %d\n", valueOfHand(dealer));
        return (isFine(dealer)) ? valueOfHand(dealer):0;
    }


    public int valueOfHand(CardHand hand) {
        int value = 0;
        int aces = 0;
        for (int i = 0;i < hand.getCardCount();i++) {
            if (hand.getCard(i).getFace() >= 10) {
                value += 10;
            } else if (hand.getCard(i).getFace() == 1) {
                value += 11;
                aces++;
            } else {
                value += hand.getCard(i).getFace();
            }
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }




}
