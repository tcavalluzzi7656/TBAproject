
package Rooms;


public class Board {
    public static Room[][] map = new Room[5][5];
    int keyxloc;
    public static int keyyloc;
    int orbxloc;
 public  static int orbyloc;
    int tomexloc;
   public static int tomeyloc;


   //two constuctors that differentiate between where the artifact rooms will be based off of the players choice
public Board()
{
    this.keyxloc=0;
     this.keyyloc=4;
     this.orbxloc=2;
     this.orbyloc=3;
     this.tomexloc=1;
     this.tomeyloc=1;
}

    public Board(boolean random)
    {
        this.keyxloc=0;
        this.keyyloc=(int)(Math.random()*5);
        this.orbxloc=2;
        this.orbyloc=(int)(Math.random()*5);
        this.tomexloc=1;
        this.tomeyloc=(int)(Math.random()*5);
    }

    //fills the map with rooms and manually places the artifact and exit rooms
    public void create()
    {
        for(int x = 0; x < map.length; ++x) {
            for(int y = 0; y < map[x].length; ++y) {
                map[x][y] = new Room(x, y);
            }
        }
        map[keyxloc][keyyloc] = new KeyRoom(keyxloc,keyyloc);
        map[tomexloc][tomeyloc]= new TomeRoom(tomexloc,tomeyloc);
        map[orbxloc][orbyloc] = new OrbRoom(orbxloc,orbyloc);
        map[4][2] = new ExitRoom(4,2);
    }

    //print the board
    public static void print(Room[][] map) {

            for (int x = 0; x < map.length; ++x) {
                String line = "";

                for (int y = 0; y < map[x].length; ++y) {
                    line = line + ("["+map[x][y].toString()+"]");

                }
                System.out.println(line);
            }

    }
}
