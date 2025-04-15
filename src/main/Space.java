// this file contains a class that represents a single space on board
// helps to store space position, color, symbol
// helper functions to access these attributes

// getSpaceColor
// getSpaceSymbol
// spaceHasSymbol
// getPosition
public class Space {

    private int index; // helps keep track where we are on the board
    private String color;
    private String symbol;

    public Space(int index, String color, String symbol) {
        // general constructor
        this.index = index;
        this.color = color;
        this.symbol = symbol;
    }

    // some getters here
    public String getSpaceColor() {
        return color;
    }

    public String getSpaceSymbol() {
        return symbol;
    }

    // need a function to check if the space has a symbol-- boolean?
    public int getSpaceIndex() {
        return index;
    }

}
