
package Rooms;

public class Board {
    public Room[][] map;

    public Board(Room[][] map) {
        this.map = map;
    }

    public static void main(String[] args)
    {
        Room[][] map = new Room[5][5];

        for(int x = 0; x < map.length; ++x) {
            for(int y = 0; y < map[x].length; ++y) {
                map[x][y] = new Room(x, y);
            }
        }
    }


    public static void print(Room[][] map) {
        for(int i = 0; i < map.length; ++i) {
            String line = "";

            for(int x = 0; x < map[i].length; ++x) {
                line = line + "[ ]";
                System.out.println(line);
            }
        }

    }
}
