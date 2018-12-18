
package Rooms;

import People.Person;

//all comments in keyroom extend to the other artifact rooms as well


public class KeyRoom extends Room {
    public static boolean key = true;

    public KeyRoom(int x, int y)
    {
        super(x, y);
        this.key = key;
    }


    //changes the tostring to the keyroom icon instead of being blank
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


    //prints text for when the player enters before and after the artifact has been taken.
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


}
