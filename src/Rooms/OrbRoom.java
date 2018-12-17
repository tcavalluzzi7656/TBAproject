
package Rooms;

import People.Person;

public class OrbRoom extends Room {
    public static boolean orb = true;

    public OrbRoom(int x, int y)
    {
        super(x, y);
        this.orb = orb;
    }

    @Override
    public String toString()
    {
        if(occupant==null) {
            return "O";
        }
        else{
            return "x";
        }
    }



    public void enterRoom(Person x) {
        if (orb) {
            System.out.println("You enter a bright room filled with crystals. In the middle an orb that seems to be stuck inside a particularly big piece of crystal.");
        } else {
            System.out.println("You enter the crystal room. The light glimmering off of the crystals is almost blinding.");
        }

        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }


}
