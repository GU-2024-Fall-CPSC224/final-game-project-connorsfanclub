package edu.gonzaga;

public class Card {

    private String color; // this could be like red, blue, green, whatever we want
    private String symbol; // the "locations" -- spike, skybridge
    private boolean isDouble; // only if we want to have the double color feature, can remove later

    public Card(String color, boolean isDouble, String symbol) {
        // general card constructor
        this.color = color;
        this.isDouble = isDouble;
        this.symbol = symbol;
    }

    // some getters
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public boolean hasSymbol() {
        return symbol != null && !symbol.isEmpty();
    }

    @Override
    public String toString() {
        if (hasSymbol()) {
            return "Symbol Card: " + symbol;
        }
        return (isDouble ? "Double " : "Single ") + "Color Card: " + color;
    }
}
