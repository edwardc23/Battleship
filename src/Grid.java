import java.util.Arrays;

public class Grid {
     String[][] board=new String[10][10];
     int Carrier=5;
     int Battleship=4;
     int Destroyer=3;
     int Submarine=2;
     int PatrolBoat=2;
   String nCarrier="Carrier";
    String nBattleship="Battleship";
    String nDestroyer="Destroyer";
    String nSubmarine="Submarine";
    String nPatrolBoat="Patrol Boat";
    public Grid(){

        for(int x=0;x<10;x++)
        {
            for(int y=0;y<10;y++)
            {
                if(x==0&&y==0)
                {
                    board[x][y]=" ";

                }
               else if(x==0&&y!=0||y==0&&x!=0)
               {
                   board[x][y]=Integer.toString(x);
                   if(x==0)
                   {
                       board[x][y]=Integer.toString(y);

                   }

               }
               else
                {
                    board[x][y]="~";

                }


            }

        }

    }
    public void printBoard()
    {
        for(int x=0;x<10;x++){
            for(int y =0;y<10;y++)
            {
                System.out.print(board[x][y]+" ");
            }
            System.out.println();
        }

    }
}
