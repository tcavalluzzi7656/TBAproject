
package Rooms;

import People.Person;

public class KeyRoom extends Room {
    public static boolean key = true;

    public KeyRoom(int x, int y)
    {
        super(x, y);
        this.key = key;
    }

    @Override
    public String toString()
    {
        if(occupant==null) {
            return "K";
        }
        else{
            return "x";
        }
    }

    public void enterRoom(Person x) {
        if (key) {
            System.out.println("You enter a dark, foul smelling room. There is an old looking key sitting upon a dusty table that only has 2 legs.");
        } else {
            System.out.println("You enter the dark room. The table is still on the ground");
        }

        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public static boolean getKey(boolean key) {
        return key;
    }
}
