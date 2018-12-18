
package People;

public class Person {
    String firstName;
    String familyName;
    int xLoc;
    int yLoc;


    //inventory flags
    public static boolean key = false;
    public static boolean orb = false;
    public static boolean tome = false;

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

    public Person(String firstName, String familyName, int xLoc, int yLoc) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
}
