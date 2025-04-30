package edu.gonzaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

    private List<Card> deck;
    private Random rand;

    public CardDeck() {
        deck = new ArrayList<>();
        rand = new Random();
        initializeDeck();
        shuffle();
    }

    // Written in for testing purposes 
    public List<Card> CardDeckNonShuffled() {
        deck = new ArrayList<>();
        rand = new Random();
        initializeDeck();
        return deck;
    }

    private void initializeDeck() {
        deck.clear(); // reset
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};

        // color cards creation
        // adds 12 cards of each color, with four as Double Cards
        for (String color : colors) {
            for (int i = 0; i < 8; i++) {
                deck.add(new Card(color, false, null)); // single card
                if (i < 4) {
                    deck.add(new Card(color, true, null)); // a couple double cards

                }
            }
        }

        // symbol cards creation
        String[] symbols = {"Spike", "SaintAls", "SkyBridge", "Herak", "Hemmingson"};
        for (String symbol : symbols) {
            deck.add(new Card(null, false, symbol));
        }
    }

    public void shuffle() {
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    // Written in for testing purposes 
    public List<Card> getDeck() {
        return deck;
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            initializeDeck();
            shuffle();
        }

        return deck.remove(deck.size() - 1); // top of deck
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
