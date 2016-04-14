package Card;

//import java.util.*;

import java.util.List;
import java.util.Random;

public class CardDeck{
    private ArrayKake<Card> deck = new ArrayKake<Card>();

    public CardDeck(int n) {
        if (n <= 13 && n >= 0) {
            makeDeck(n);
        } else throw new IllegalArgumentException("Durp");
    }

    public CardDeck(CardDeck... decks) {
        for (int i = 0;i < decks.length;i++) {
            for (int j = 0;j < decks[i].getCardCount();j++) {
                deck.add(decks[i].getCard(j));
            }
        }
    }


    private void makeDeck(int n) {
        for (int i = 0;i < 4;i++) {
            for (int j = 1;j <= n;j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public int getCardCount() {
        return deck.size();
    }

    public Card getCard(int i) {
        try {
            return deck.get(i);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid index");
        }
    }


    public void deal(CardHand hand) {
        deal(hand, 1);
    }

    public void deal(CardHand hand, int n) {
        for (int i = 0;i < n;i++) {
            hand.addCard(deck.removeLast());
        }
    }


    public void shufflePerfectly() {
        List<Card> first = deck.subList(0, deck.size()/2);
        List<Card> second = deck.subList(deck.size()/2, deck.size());
        deck = new ArrayKake<Card>();
        for (int i = 0;i < first.size();i++) {
            deck.add(first.get(i));
            deck.add(second.get(i));
        }
    }

    public void shuffle() {
        List<Card> shuffleDeck = deck;
        System.out.println(shuffleDeck.size());
        Card[] cardDeck = new Card[shuffleDeck.size()];
        deck = new ArrayKake<Card>();
        Random ran = new Random();
        int isFull = 0, randomNum ;
        while (isFull != cardDeck.length) {
            randomNum = ran.nextInt(cardDeck.length);
            if (cardDeck[randomNum] == null) {
                cardDeck[randomNum] = shuffleDeck.remove(0);
                isFull++;
            }
        }
        for (Card card : cardDeck) {
                deck.add(card);
        }
    }



}




