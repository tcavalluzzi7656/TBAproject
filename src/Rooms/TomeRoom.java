
package Rooms;

import People.Person;

public class TomeRoom extends Room {
    public static boolean tome = true;

    public TomeRoom(int x, int y)
    {
        super(x, y);
        this.tome = tome;
    }

    @Override
    public String toString()
    {
        if(occupant==null) {
            return "T";
        }
        else{
            return "x";
        }
    }



    public void enterRoom(Person x) {
        if (tome) {
            System.out.println("You enter a room lit by several candles. It is filled with several bookshelves, one of which in particular holds a book radiating immense pressure.");
        } else {
            System.out.println("You enter the room filled with bookshelves. You contemplate staying and reading a little bit, but the thought of education repulses you.");
        }

        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }


}
