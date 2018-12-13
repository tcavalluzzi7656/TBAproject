
package Game;

import People.Person;
import Rooms.Board;
import Rooms.KeyRoom;
import Rooms.Room;

import java.security.Key;
import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;

    public Runner() {
    }

    public static void main(String[] args) {
        Board.create();

        Person player1 = new Person("FirstName", "FamilyName", 0, 0);
        KeyRoom table = new KeyRoom(4,4);
        Board.map[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);

        while(gameOn) {
            System.out.println("What would you like to do?");
            Board.print(Board.map);
            String move = in.nextLine();
            if (!validMove(move, player1, Board.map, table)) {
                System.out.println("Please choose a valid move.");
            }
        }

        in.close();
    }

    public static boolean validMove(String move, Person player1, Room[][] map, KeyRoom table) {
        move = move.toLowerCase().trim();
        byte var4 = -1;
        switch(move.hashCode()) {
            case 101:
                if (move.equals("e")) {
                    var4 = 1;
                }
                break;
            case 110:
                if (move.equals("n")) {
                    var4 = 0;
                }
                break;
            case 115:
                if (move.equals("s")) {
                    var4 = 2;
                }
                break;
            case 102:
                if (move.equals("take key")) {
                    var4 = 4;
                }
                break;
            case 119:
                if (move.equals("w")) {
                    var4 = 3;
                }
        }

        switch(var4) {
            case 0:
                if (player1.getxLoc() > 0) {
                    map[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);
                    map[player1.getxLoc() - 1][player1.getyLoc()].enterRoom(player1);
                    return true;
                }

                return false;

            case 4:
                if ((player1.getxLoc() == table.getxLoc())&&(player1.getyLoc()==table.getyLoc())) {
                    table.key = false;
                    player1.key=true;
                    System.out.println("You picked the key up off of the table. The minuscule chance in weight caused the table to go crashing to the floor.");
                    return true;
                }
                return false;

            case 1:
                if (player1.getyLoc() < map[player1.getyLoc()].length - 1) {
                    map[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);
                    map[player1.getxLoc()][player1.getyLoc() + 1].enterRoom(player1);
                    return true;
                }

                return false;
            case 2:
                if (player1.getxLoc() < map.length - 1) {
                    map[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);
                    map[player1.getxLoc() + 1][player1.getyLoc()].enterRoom(player1);
                    return true;
                }

                return false;
            case 3:
                if (player1.getyLoc() > 0) {
                    map[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);
                    map[player1.getxLoc()][player1.getyLoc() - 1].enterRoom(player1);
                    return true;
                }

                return false;
            default:
                return true;
        }
    }

    public static void gameOff() {
        gameOn = false;
    }
}
