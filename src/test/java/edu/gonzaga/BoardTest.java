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

        int symbolIndex = 0;
        
        String[] expectedColors = {"red", "blue", "green", "yellow", "orange", "purple"};
        String[] expectedSymbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};
        
        for (int i =0; i < 50; i++) {

            // Tests that all 50 colors in expected color list are in correct indexes
            String expectedColor = expectedColors[ i % expectedColors.length];
            assertEquals(expectedColor, spaces.get(i).getSpaceColor());
        

            // Test that all 5 symbols in expected symbol list are in correct indexes 
            String expectedSymbol = null;
            if(i % 10 == 0 && symbolIndex < expectedSymbols.length){
                expectedSymbol = expectedSymbols[symbolIndex];
                symbolIndex = symbolIndex + 1;
            }
            assertEquals(expectedSymbol, spaces.get(i).getSpaceSymbol(), "Error at " + expectedSymbol + " at index " + i);
        }
    }
    

    @Test 
    void getNextSpace() {
        Board board = new Board();
        board.initializeBoard();
        Player player = new Player("player1", null);

        // Tests (!isDouble & count == 1)
        int test = board.getNextSpace("red", 0, false);
        assertEquals(test, 6, "Error, expected 6 but got " + test);

        // Tests (!isDouble & count == 1) through a player position passsed in
        int test2 = board.getNextSpace("red", player.getPosition(), false);
        assertEquals(test2, 6, "Error, expected 6 but got " + test2);

        // Tests (isDouble & count == 2) 
        int test3 = board.getNextSpace("red", 5, true);
        assertEquals(test3, 12, "Error, expected 12 but got " + test3);

        // Tests end of board 
        int test4 = board.getNextSpace("blue", 49, false);
        assertEquals(test4, 49, "Error, expected 49 but got " + test4);

    }

    @Test 
    void testGetSymbolIndex() {
        Board board = new Board();
        board.initializeBoard();

        // Tests symbol index of first element in Symbols
        int test = board.getSymbolIndex("Spike");
        assertEquals(test, 10, "Error, expected 10 but got " + test);

        //Tests symbol index of last element in Symbols 
        int test2 = board.getSymbolIndex("Hemmingson");
        assertEquals(test2, 40, "Error, expected 40 but got " + test2);
    }

    @Test 
    void testMovePlayerToken() {
        Board board = new Board();
        board.initializeBoard();
        Player player = new Player("player1", null);

        // Tests moving a player to a symbol
        Card card = new Card(null, false, "Spike");
        board.movePlayerToken(player, card);
        assertEquals(player.getPosition(), 10, "Error, expected 10 but got " + player.getPosition());

        // Tests moving a player to a color
        Card card2 = new Card("blue", false, null);
        board.movePlayerToken(player, card2);
        assertEquals(player.getPosition(), 13, "Error, expected 13 but got " + player.getPosition());
    }

}
