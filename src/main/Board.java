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
import java.util.List;
import java.util.ArrayList;
// need to reference the Space class so there's no errors

public class Board {

    private List<Space> spaces = new ArrayList<>();
    // do we need another private member variable for the symbols??

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        // can replace this with whatever, I just put stuff
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
        String[] symbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};

        int symbolIndex = 0;
        int colorIndex = 0;

        for(int i = 0; i < 50 ; i++) {
            String color = colors[colorIndex];
                colorIndex = colorIndex +1;
            if(colorIndex == colors.length) {
                colorIndex = 0;
            }      

            String symbol = null;
            if (i % 10 == 0 && symbolIndex < symbols.length){
                symbol = symbols[symbolIndex];
                symbolIndex =  symbolIndex +1;
            }

            Space space = new Space (i, color, symbol);
            spaces.add(space);

        }
    }  
            
            
          
            
        // implement here
    }

    public Space getSpace(int index) {
        return spaces.get(index);
    }

    // need the getNextSpace public function here?
   // get the index of the next space with color 
   public int getNextSpace(String color, int startIndex, boolean isDouble) {
       int count = 0;

       for(int i = stardIndex +1; i < spaces.size() ; i++){
           if (spacess.get(i).getSpaceColor().equalsIgnoreCase(color)){
               count = count +1;
               if(!isDouble && count == 1){
                   return i;
               }else if (isDouble && count == 2) {
                   return i;
               }
           }
       }       
    public boolean isEnd(int index) // this is a way to see if the player is at end of board?
    {
        return index >= spaces.size() - 1;
    }
}

