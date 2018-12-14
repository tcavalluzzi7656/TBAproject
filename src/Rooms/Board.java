
package Rooms;

import People.Person;

public class Board {
    public static Room[][] map = new Room[5][5];


    public board
    public static void create()
    {
        for(int x = 0; x < map.length; ++x) {
            for(int y = 0; y < map[x].length; ++y) {
                map[x][y] = new Room(x, y);
            }
        }
        map[4][4] = new KeyRoom(4,4);
    }


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
