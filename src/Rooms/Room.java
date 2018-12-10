
package Rooms;

import People.Person;

public class Room {
    Person occupant;
    int xLoc;
    int yLoc;

    public Room(int x, int y) {
        this.xLoc = x;
        this.yLoc = y;
    }

    public void enterRoom(Person x) {
        System.out.println("You enter a plain old room");
        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void leaveRoom(Person x) {
        this.occupant = null;
    }
}
