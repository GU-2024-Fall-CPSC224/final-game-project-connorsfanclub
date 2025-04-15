
import javax.management.DescriptorKey;

// this file contains the deck of cards used in the game
// this mainly should handle the card deck (shuffling, drawing, checking if empty)
// some attributes/methods we may want to include
// shuffleDeck
// drawFromDeck (should return top card)- after shuffled
// isEmpty
public class CardDeck {
    // store the deck of cards here in a private attribute?

    public CardDeck() {
        // can call this and will call other functions
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        // idk how we want to do this yet
        // push back each card from card class (both normal color cards and any special symbol cards)
    }

    public void shuffle() {
        // implement later
    }

    public Card drawCard() { // need to import the card class no error?
        // implement later
        // will return a card element?
    }

    // public boolean isEmpty() {
    //     // here checks if the deck is empty
    // }
}
