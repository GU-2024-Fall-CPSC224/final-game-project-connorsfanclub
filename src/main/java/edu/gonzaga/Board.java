// this file will contain the board class
// it will create and manage spaces, keep track of where each player is,
// and determine the next space based on the given card color/symbol
// some attributes/methods we want is:
// spaces: List<Space> (actual game board)
// players: List<Player> (players on board)
// setBoard() : initializes the board
// getNextSpace(String color): finds the next space to match card
// movePlayerToken(Player p, Space s): moves the player across board
// getSpace(int index): get the space by position on board
// note: this class should interact with both space and player classes?
package edu.gonzaga;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Space> spaces = new ArrayList<>();
    // do we need another private member variable for the symbols??

    public Board() {
    }

    public void initializeBoard() {
        // can replace this with whatever, I just put stuff
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
        String[] symbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};
        int colorIndex = 0;
        int symbolIndex = 0;

        for(int i = 0; i < 50 ; i++){
            String color = colors[colorIndex];
            colorIndex = colorIndex + 1;
            if(colorIndex == colors.length) {
                colorIndex = 0;
            }

            String symbol = null;
            if(i % 10 == 0 && symbolIndex < symbols.length){
                symbol = symbols[symbolIndex];
                symbolIndex = symbolIndex + 1;
            }
            Space space = new Space(i, color, symbol);
            spaces.add(space);
        }
    }  

    // Written in for testing purposes 
    public List<Space> getSpaces() {
        return spaces;
    }

    public Space getSpace(int index) {
        return spaces.get(index);
    }

    // need the getNextSpace public function here?
    public boolean isEnd(int index) {// this is a way to see if the player is at end of board? 
        return index >= spaces.size() - 1;
    }

    public int getNextSpace(String color, int startIndex, boolean isDouble){
        int count = 0; 

        for(int i = startIndex + 1; i < spaces.size(); i++){
            Space nextSpace = spaces.get(i);
            String spaceColor = nextSpace.getSpaceColor();

            if(spaceColor.equals(color)){
                // DEBUG: System.out.println("DEBUG: getNextSpace: pre-count = " + count);
                count = count + 1;
                // DEBUG: System.out.println("DEBUG: getNextSpace: post-count = " + count);
                // DEBUG: System.out.println("DEBUG: isDouble = " + isDouble);

                // Single color card, player moves to first match of that color 
                // double color card, player moves to the second match of that color 
                if((!isDouble) & (count == 1) || (isDouble) & (count == 2)){
                    // DEBUG: System.out.println("getNextSpace: first if state: " + i);
                    return i;
        
                }
            }       
        }   
        
        // This is meant to represent the end of board 
        // DEBUG: System.out.println("getNextSpace: end of board");
        return spaces.size() - 1;
    }

    public int getSymbolIndex(String symbol){
        for(int i = 0; i < spaces.size(); i++){
            Space currentSpace = spaces.get(i);
            String spaceSymbol = currentSpace.getSpaceSymbol();

            if (spaceSymbol != null && spaceSymbol.equals(symbol)){
                return i;
            }    
        }
            return -1;

    }

    public void movePlayerToken(Player player, Card card) {
        int newIndex;

        if(card.hasSymbol()){
            String symbol = card.getSymbol();
            newIndex = getSymbolIndex(symbol);
        }else{
            int currentIndex = player.getPosition();
            String cardColor = card.getColor();
            boolean isDouble = card.isDouble();
            newIndex = getNextSpace(cardColor, currentIndex, card.isDouble());
        }  
         if(newIndex != -1){
             player.moveTo(newIndex);


        }
    }

    // Written in for testing purposes
    public void setSpace(int index, String color, String symbol) {
        spaces.remove(index);
        spaces.add(new Space(index, color, symbol));
    }

}      
