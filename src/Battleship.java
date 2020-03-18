import java.util.Scanner;

public class Battleship {
    static Scanner in = new Scanner(System.in);
  static boolean gameOver=false;
  static int i =0;
  static int turns=0;
    public static void main(String[] args) {
        System.out.println("Battleship Multiplayer");
        System.out.println("Enter Player 1 name: ");
        Player player1=new Player(in.next());
        System.out.println("Enter Player 2 name: ");
        Player player2=new Player(in.next());
while(!gameOver) {
    if(i==0){
//    player1.addPieces("Carrier");
//    player1.gridP.printBoard();
//    player1.addPieces("Battleship");
//    player1.gridP.printBoard();
//    player1.addPieces("Destroyer");
//    player1.gridP.printBoard();
//    player1.addPieces("Submarine");
//    player1.gridP.printBoard();
//    player1.addPieces("PatrolBoat");
//    player1.gridP.printBoard();

    player2.addPieces("Carrier");
    player2.gridP.printBoard();
    player2.addPieces("Battleship");
    player2.gridP.printBoard();
    player2.addPieces("Destroyer");
    player2.gridP.printBoard();
    player2.addPieces("Submarine");
    player2.gridP.printBoard();
    player2.addPieces("PatrolBoat");
    player2.gridP.printBoard();
    i++;}
    else if(turns%2==0){
        System.out.println(player1.name+" ,Enter the coordinates of your guess: ");
        String p1=in.next();
        player1.guessIt(player2,p1);
        player2.gridP.printBoard();

   }
//    else
//    {
//        System.out.println(player2.name+" ,Enter the coordinates of your guess: ");
//        String p1=in.next();
//        player1.guessIt(player2,p1);
//        player1.gridP.printBoard();
//        turns++;
//    }
    if(player1.won||player2.won)
    {
        System.out.println("Play again Y or N");
        String ans=in.next();
        if(ans.equals("N"))
        {
        gameOver=true;
        break;
        }
        else if(ans.equals("Y"))
        {
            player1.won=false;
            player2.won=false;
                i=0;
                turns=0;
            System.out.println("Enter Player 1 name: ");
             player1=new Player(in.next());
            System.out.println("Enter Player 2 name: ");
             player2=new Player(in.next());
        }

    }
}


    }
}
