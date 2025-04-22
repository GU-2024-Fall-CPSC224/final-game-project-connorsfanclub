package edu.gonzaga;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BoardTest {
    
    @Test
    void testInitializeBoard() {
        Board board = new Board();
        board.initializeBoard();

        // Tests is the board has 50 spaces
        List<Space> spaces = board.getSpaces();
        assertEquals(50, spaces.size());

        // Tests that all 50 colors are in expected color list 
        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        for (int i =0; i < 50; i++) {
            String expectedColor = expectedColors[ i % expectedColors.length];
            assertEquals(expectedColor, spaces.get(i).getSpaceColor());
        }

        // Test that all 50 symbols are in expected symbol list
        String[] expectedSymbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};
        for (int i = 0; i < 50; i++) {
            String expectedSymbol = expectedSymbols[ i % expectedSymbols.length];
            assertEquals(expectedSymbol, spaces.get(i).getSpaceSymbol());
        }
    }
    
    @Test 
    void testIsEnd(int index) {

    }

    @Test 
    void testGetSymbolIndex(String symbol) {

    }

    @Test 
    void testMovePlayerToken(Player player, Card card) {

    }

}
