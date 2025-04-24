package edu.gonzaga;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardDeckTest {
    
    @Test 
    void testInitializeDeck() {

        // initializeDeck() function is called in constructor 
        CardDeck cardDeck = new CardDeck();
        List<Card> deck = cardDeck.CardDeckNonShuffled();

        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        int count = 0;
        for (int i = 0; i < expectedColors.length; i++) {
            for (int j = 0; j <= 11; j++) {
                assertEquals(deck.get(count).getColor(), expectedColors[i], "Expected " + expectedColors[i] + " but got " + deck.get(count).getColor() + " at " + i + ", " + j);
                count += 1;
            }
        } 
    }

    @Test 
    void testShuffle() {

    }

    @Test 
    void testDrawCard() {

    }

}
