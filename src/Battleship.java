import java.util.Scanner;

public class Battleship {
    static Scanner in = new Scanner(System.in);
   static String player1,player2;
   static Grid grid=new Grid();
    public static void main(String[] args) {
        System.out.println("Battleship Multiplayer");
        System.out.println("Enter Player 1 name: ");
        Player player1=new Player(in.next());
        System.out.println("Enter Player 2 name: ");
        Player player2=new Player(in.next());

player1.addPieces("Carrier");
player1.gridP.printBoard();
player1.addPieces("Battleship");
player1.gridP.printBoard();
player1.addPieces("Destroyer");
player1.gridP.printBoard();
player1.addPieces("Submarine");
player1.gridP.printBoard();
player1.addPieces("Patrol Boat");
player1.gridP.printBoard();
//player2.addPieces();
        int Carrier=5;
        int Battleship=4;
        int Destroyer=3;
        int Submarine=2;
        int PatrolBoat=2;


//         player1.gridP.printBoard(); System.out.println();
//        player2.gridP.printBoard();
    }
}
