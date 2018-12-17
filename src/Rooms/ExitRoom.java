
package Rooms;

import Game.Runner;
import People.Person;

public class ExitRoom extends Room {

    public ExitRoom(int x, int y)
    {
        super(x, y);
    }

    @Override
    public String toString()
    {
        if(occupant==null) {
            return "E";
        }
        else{
            return "x";
        }
    }



    public void enterRoom(Person x) {
        if (Person.key&&Person.orb&&Person.tome) {
            System.out.println("You exit the ruins with all three items in your possession. You return to Gundran and give them back to him. He expresses his gratitude by offering to house you for the rest of your life. He offers you a hug, which you accept");
            System.out.println("Unfortunately for you, Gundran has no plans of housing you, and instead plans for your spinal column to house his dagger.");
            System.out.println("He helps his friend move into your prime real estate, while your life's flame extinguishes on the floor. At least, in the end, you helped a friend. Even if they weren't a friend.");
            Runner.gameOff();
        } else {
            System.out.println("You peer out the exit of the ruins. You think for a minute about returning to Gundran without everything he asked for, but decided that you would uphold your honor as a true friend and not leave until you're dead or successful.");
        }

        this.occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }


}
