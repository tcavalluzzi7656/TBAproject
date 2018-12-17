
package Rooms;

import Game.Runner;
import People.Person;

public class Room {
    Person occupant;
    int xLoc;
    int yLoc;

    public int getxLoc() {
        return this.xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc()
    {
        return this.yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Room(int x, int y) {
        this.xLoc = x;
        this.yLoc = y;
    }

    public void enterRoom(Person x) {
        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        double random = Math.random();
        if(random>.5)
        {
            System.out.println("You enter a plain old room");
        }
        if((random<=.5)&&(random>.25)) {
            System.out.println("You spot a pressure plate in the middle of the room, and successfully avoid pressing it.");
        }
        if((random<=.25)&&(random>.05)) {
            System.out.println("You're attacked by a rat as you enter, and successfully subdue it with your dagger.");
        }
        if((random<=.05)&&(random>.025)) {
            System.out.println("You're attacked by a rat as you enter, which ends up biting your jugular. You lie there and bleed out as you realize that the rat was in fact not a rat at all, but a very angry vole.");
            Runner.gameOff();
        }
        if((random<=.025)&&(random>0)) {
            System.out.println("You step on a pressure plate in the middle of the room. You hear an arrow fire from behind you and your vision goes blank as you fall to the floor paralyzed, where you remain until you starve.");
            Runner.gameOff();
        }
        if(random==0)
        {
            System.out.println("As you enter this room you look up and see a massive cyclops staring back at you. It fires a beam at you, entrapping you in stone. You remain there for centuries until an explorer with actual fighting prowess uses you as a shield, destroying you and your imprisoned conciseness in the process.");
         Runner.gameOff();
        }
    }

    public String toString()
    {
        if(occupant==null) {
            return " ";
        }
        else{
            return "x";
        }
    }

    public void leaveRoom(Person x) {
        this.occupant = null;
    }
}
