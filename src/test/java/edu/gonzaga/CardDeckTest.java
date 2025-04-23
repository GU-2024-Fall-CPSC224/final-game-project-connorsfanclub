package edu.gonzaga;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardDeckTest {
    
    @Test 
    void testInitializeDeck() {

        // initializeDeck() function is called in constructor 
        CardDeck cardDeck = new CardDeck();
        List<Card> deck = cardDeck.getDeck();

        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        for (int i = 0; i < expectedColors.length; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(deck.get(j), expectedColors[i], "Expected " + expectedColors[i] + " but got " + deck.get(j));
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
