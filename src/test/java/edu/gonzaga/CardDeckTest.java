package edu.gonzaga;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CardDeckTest {
    
    @Test 
    void testInitializeDeck() {

        // initializeDeck() function is called in constructor 
        CardDeck cardDeck = new CardDeck();

        // Function written for testing purposes, to unshuffle deck so cards are grouped by color
        List<Card> deck = cardDeck.CardDeckNonShuffled();

        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        int count = 0;

        // Tests that there are 12 cards for each color in deck 
        for (int i = 0; i < expectedColors.length; i++) {
            for (int j = 0; j <= 11; j++) {
                assertEquals(deck.get(count).getColor(), expectedColors[i], "Expected " + expectedColors[i] + " but got " + deck.get(count).getColor() + " at " + i + ", " + j);
                count += 1;
            }
        } 
    }

    @Test 
    void testShuffle() {
        CardDeck cardDeck = new CardDeck();

        // Tests that the first card of the deck is not the same color as the second card's color
        String firstCard = cardDeck.drawCard().getColor();
        String secondCard = cardDeck.drawCard().getColor();
        assertTrue(!(firstCard.equals(secondCard)));
    }

    @Test 
    void testDrawCard() {
        CardDeck cardDeck = new CardDeck();

        // Tests that drawCard() returns a Card object 
        assertInstanceOf(Card.class, cardDeck.drawCard(), "Error, drawCard() did not return a Card object.");
    }

}
