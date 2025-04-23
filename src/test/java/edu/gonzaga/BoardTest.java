package edu.gonzaga;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BoardTest {
    
    @Test
    void testInitializeBoard() {
        Board board = new Board();
        board.initializeBoard();

        // Tests is the board has 50 spaces
        List<Space> spaces = board.getSpaces();
        assertEquals(50, spaces.size());

        int symbolIndex = 0;
        // Tests that all 50 colors are in expected color list 
        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        for (int i =0; i < 50; i++) {
            String expectedColor = expectedColors[ i % expectedColors.length];
            assertEquals(expectedColor, spaces.get(i).getSpaceColor());
        

        // Test that all 50 symbols are in expected symbol list
            String[] expectedSymbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};
            String expectedSymbol = null;
            if(i % 10 == 0 && symbolIndex < expectedSymbols.length){
                expectedSymbol = expectedSymbols[symbolIndex];
                symbolIndex = symbolIndex + 1;
            }
            assertEquals(expectedSymbol, spaces.get(i).getSpaceSymbol(), "Error at " + expectedSymbol + " at index " + i);
        }
    }
    
    // Confused on the getNextSpace() function!
    // why does it return the size of spaces List?
    // why does it have an if/else loop that does the same thing?
    @Test 
    void getNextSpace() {
        Board board = new Board();
        board.initializeBoard();

        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        // Finish when function is clarified
    }

    @Test 
    void testGetSymbolIndex() {
        Board board = new Board();
        board.initializeBoard();

        String[] expectedSymbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};

        // Not quite sure this accomplishes what is intended
        //for (int i = 0; i < expectedSymbols.length; i++) {
        //    String symbol = expectedSymbols[i];
        //    int actualIndex = board.getSymbolIndex(symbol);
        //    assertEquals(i, actualIndex, "Expected symbol " + symbol + " at index " + i + " but got " + actualIndex);
        //}

        // Checks if pre-set symbol is at expected index from function
        board.setSpace(5, "red", "Spike");
        int functionIndex = board.getSymbolIndex("Spike");
        assertEquals(5, functionIndex, "Expected symbol 'Spike' at index 5 but got " + functionIndex);
    }

    @Test 
    void testMovePlayerToken() {
        Board board = new Board();
        board.initializeBoard();
        Card card = new Card("red", false, "Spike");
        Player player = new Player("One", "red");

        board.movePlayerToken(player, card);
        board.setSpace(5, "red", "Spike");

        assertTrue(player.getPosition() == 5, "Error, expected 5 but got " + player.getPosition());
    }

}
