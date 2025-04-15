// this file will contain the player class which:
// stores players name, token color, and current position on board
// provides general player info

// some attributes/methods we may want to include:
// moveTo(Space s): moves player to a new space
// getPlayerName: getter for returning players name (also want a setter?)
// getPosition(): return for current space
public class Player {

    private String name;
    // idk how we want to store the token color of the player here?
    private int position; // position of this particular player on the board

    public Player(String name) {
        // constructor (should prob initialize with token color too)
        this.name = name;
        this.position = 0;
    }

    public void moveTo(int newPosition) {
        this.position = newPosition; // updates player position here
    }

    // getters here
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // getter for token color here
}
