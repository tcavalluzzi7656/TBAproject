
package Game;

import People.Person;
import Rooms.*;

import java.security.Key;
import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;
    static boolean random = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean random=false;

        //sets a flag for creation of random or standard board
        System.out.println("Would you like to play with a random board, or a pre-made one?");
        String move = in.nextLine();
        if(move.contains("random"))
        {
            random = true;
        }

        Board map = new Board();
        if(random)
        {
            map=new Board(random);
        }

        //creates either random or pre set board
        map.create();


        //creates instances of rooms in the correct position
        Person player1 = new Person("FirstName", "FamilyName", 4, 2);
        KeyRoom table = new KeyRoom(0,Board.keyyloc);
        OrbRoom crystal = new OrbRoom(2,Board.orbyloc);
        TomeRoom book = new TomeRoom(1,Board.tomeyloc);


        //prints backstory and explanation of game
        System.out.println("You are a lone elf who wanders the world, in search of some petty coin and thrills. In a local tavern, you meet a dwarf named Gundran, who claims to be your long lost cousin");
        System.out.println("He tells you that he has a job that he would love you to complete for him, adn that he would reward you handsomely for completing it. He tells you a local story about three mystic artifacts that are supposed to be in the cave.");
        System.out.println("The first, is the Skeleton Key, said to be able to open any lock. The second is the Philosophers Stone, said to be able to create matter from nothing. The third is the Tome of the Elders, said to give the reader the knowledge of 100 one-hundred year old men.");
        System.out.println("You agree to help Gundran find the artifacts. Not only does he promise you a reward, you're hoping that you may be able to get some use out of the artifacts yourself.");
        System.out.println("Gundran gives you a map of what the ruins most likely look like. He has marked the locations of all three artifacts, and reassures you that this should be an easy job with no threat of danger.");
        System.out.println("He says he would do it himself if he didn't have his back problems, and if his favorite cousin wasn't there to help him with it.");
        System.out.println("Gundran leads you to the ruins, and you descend deep into them as he returns back to town.");


        //places character in correct starting position
        Board.map[4][2].enterRoom(player1);


        while(gameOn) {
            //checks what player will do
            System.out.println("What would you like to do?");
            Board.print(Board.map);
            move = in.nextLine();
            if (!validMove(move, player1, Board.map, table,book, crystal)) {
                System.out.println("Please choose a valid move.");
            }
        }

        in.close();
    }

    public static boolean validMove(String move, Person player1, Room[][] map, KeyRoom table,TomeRoom book,OrbRoom crystal) {
        move = move.toLowerCase().trim();
        byte var4 = -1;
        //checks the different cases for inputs
        switch(move) {
            case "w":
                {
                    var4 = 3;
                }
                break;
            case "n":
                {
                    var4 = 0;
                }
                break;
            case "s":
                {
                    var4 = 2;
                }
                break;
            case "take key":
                {
                    var4 = 4;
                }
                break;
            case "take tome":
            {
                var4 = 5;
            }
            break;
            case "take orb":
            {
                var4 = 6;
            }

            break;
            case "help":
            {
                var4 = 7;
            }
            break;
            case "inventory":
            {
                var4 = 8;
            }
            break;
            case "e":
                {
                    var4 = 1;
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

            case 8:
                //returns all possible inventory texts
                if (!Person.orb&&!Person.tome&&!Person.key)
                {
                    System.out.println("You currently don't have any artifacts. Get a move on!");
                }
                if (Person.orb&&!Person.tome&&!Person.key)
                {
                    System.out.println("You currently have the Philosopher's Stone. You still need the Skeleton Key and the Tome of the Elders!");
                }
                if (!Person.orb&&Person.tome&&!Person.key)
                {
                    System.out.println("You currently have the Tome of the Elders. You still need the Philosopher's Stone and the Skeleton Key!");
                }
                if (!Person.orb&&!Person.tome&&Person.key)
                {
                    System.out.println("You currently have the Skeleton Key. You still need the Philosopher's Stone and the Tome of the Elders!");
                }

                if (!Person.orb&&Person.tome&&Person.key)
                {
                    System.out.println("You currently have the Skeleton Key and the Tome of the Elders. You still need the Philosopher's Stone!");
                }
                if (Person.orb&&!Person.tome&&Person.key)
                {
                    System.out.println("You currently have the Skeleton Key and the Philosopher's Stone. You still need the Tome of the Elders!");
                }
                if (Person.orb&&Person.tome&&!Person.key)
                {
                    System.out.println("You currently have the Philosopher's Stone and the Tome of the Elders. You still need the Skeleton Key!");
                }
                if (Person.orb&&Person.tome&&Person.key)
                {
                    System.out.println("You have all the artifacts! Get to the exit and deliver them to Gundran!");
                }
                return true;
            case 7:
                //prints instructions for the game
                System.out.println("Your goal is to retrieve all 3 artifacts within the ruins and bring them to the exit.");
                System.out.println("Entering rooms that don't contain an artifact has a chance to be dangerous, so try to get from place to place as quickly as possible");
                System.out.println("MOVEMENT: Use the commands n,s,e,w to go north, south, east and west respectively");
                System.out.println("RETRIEVAL: Use the take command to take an artifact that you are in the room with into your possession.");
                System.out.println("INVENTORY: Use the command inventory to check which artifacts you currently have.");
                return true;


            //sets flags within the room and player to show the change of the artifact location, and prints associated text
            case 4:
                if ((player1.getxLoc() == table.getxLoc())&&(player1.getyLoc()==table.getyLoc())) {
                    if(KeyRoom.key) {
                        KeyRoom.key = false;
                        Person.key = true;
                        System.out.println("You picked the key up off of the table. The minuscule chance in weight caused the table to go crashing to the floor.");
                        System.out.println(" .--.");
                        System.out.println("/.-. '----------.");
                        System.out.println("\\'-' .--\"--\"\"-\"-'");
                        System.out.println(" '--'");
                        System.out.println("You got the Skeleton Key!");
                        return true;
                    }
                    System.out.println("You already picked up the key. You're reminded of the carnage you created in doing so.");
                    return true;
                }
                return false;

            case 5:
                if ((player1.getxLoc() == book.getxLoc())&&(player1.getyLoc()==book.getyLoc())) {
                    if(TomeRoom.tome) {
                        TomeRoom.tome = false;
                        Person.tome = true;
                        System.out.println("You walk over to the book exerting the pressure and take it off of the shelf. You feel somewhat smarter (You are not any smarter then you were before)");
                        System.out.println("      __...--~~~~~-._   _.-~~~~~--...__\n" +
                                "    //               `V'               \\\\ \n" +
                                "   //                 |                 \\\\ \n" +
                                "  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ \n" +
                                " //__.....----~~~~._\\ | /_.~~~~----.....__\\\\\n" +
                                "====================\\\\|//====================\n" +
                                "                    `---`");
                        System.out.println("You got the Tome of the Elders!");
                        return true;
                    }
                    System.out.println("You already picked up the tome. You decide to take a peek into it instead. After scanning the first page for a good few minutes, you realize that you cannot read.");
                    return true;
                }
                return false;

            case 6:
                if ((player1.getxLoc() == crystal.getxLoc())&&(player1.getyLoc()==crystal.getyLoc())) {
                    if(OrbRoom.orb) {
                        OrbRoom.orb = false;
                        Person.orb = true;
                        System.out.println("You pull at the orb until it breaks loose from the crystal and goes flying out of your hands, slamming into a wall. It develops a small crack, but you assume its fine.");
                        System.out.println("     ____\n" +
                                "       .-\" +' \"-.\n" +
                                "      /.'.'A_'*`.\\\n" +
                                "     |:.*'/\\-\\. ':|\n" +
                                "     |:.'.||\"|.'*:|\n" +
                                "      \\:~^~^~^~^:/\n" +
                                "       /`-....-'\\\n" +
                                "      /          \\\n" +
                                "      `-.,____,.-'\n");
                        System.out.println("You got the Philosopher's Stone!");
                        return true;
                    }
                    System.out.println("You already picked up the orb. You begin to worry that the crack you made may end up having severe consequences down the line.");
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

    public static void gameOff()
    {
        gameOn = false;
    }
}
