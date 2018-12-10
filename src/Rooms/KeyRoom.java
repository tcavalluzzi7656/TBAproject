
package Rooms;

import People.Person;

public class KeyRoom extends Room {
    public boolean key = true;

    public KeyRoom(int x, int y) {
        super(x, y);
        this.key = this.key;
    }

    public void enterRoom(Person x) {
        if (this.key) {
            System.out.println("You enter a dark, dank shack. There is an old looking key sitting upon a table with only 2 legs.");
        } else {
            System.out.println("You enter the shack. The table is still on the ground");
        }

        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public static boolean getKey(boolean key) {
        return key;
    }
}
