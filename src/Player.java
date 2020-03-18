import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player{
    Scanner in = new Scanner(System.in);
    String name;
    Grid gridP=new Grid();
    String [][] Board=new String[10][10];
    String typeOfShip;
    int c=5;
    int b=4;
    int d=3;
    int s=2;
    int p=2;
    boolean won=false;


    ArrayList<Ship> g=new ArrayList<>();
    public Player(String name)
    {
        this.name=name;

        this.Board=gridP.board;
    }

    public void addPieces(String type)
    {String sName="";
    int space=0;
    String e="";
        if(type.equals("Carrier")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the "+ gridP.nCarrier+": ");
        sName=gridP.nCarrier;
        space=gridP.Carrier;
        e="C";
        }
       else if(type.equals("Battleship")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the "+ gridP.nBattleship+": ");
            sName=gridP.nBattleship;
            space=gridP.Battleship;
            e="B";
       }
        else if(type.equals("Destroyer")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the "+ gridP.nDestroyer+": ");
            sName=gridP.nDestroyer;
            space=gridP.Destroyer;
            e="D";

        }
        else if(type.equals("Submarine")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the "+ gridP.nSubmarine+": ");
            sName=gridP.nSubmarine;
            space=gridP.Submarine;
            e="S";
        }
        else if(type.equals("PatrolBoat")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the "+ gridP.nPatrolBoat+": ");
            sName=gridP.nPatrolBoat;
            space=gridP.PatrolBoat;
            e="P";
        }


     String s=in.next();
     int t=0;
      int x=0,y=0;
      String pl="not empty";
         for(char d:s.toCharArray())
         {
             if(d!='('&&d!=')'&&d!=','&&Character.isDigit(d))
             {
                 if(t==0)
                 {
                      x=Integer.parseInt(String.valueOf(d));

                             t++;
                 }
                 else
                 {
                     y=Integer.parseInt(String.valueOf(d));

                 }
             }
         }
        System.out.println("Place horizontally or vertically(h or v)? ");
         while(!pl.isEmpty())
         {
             if(!pl.equals("v"))
             {
                 if (!pl.equals("h"))
                 {
                     pl=in.next();
                 }
                 else
                 {
                     break;
                 }
             }
             else
             {
                 break;
             }

         }
         g.add(new Ship(x,y,pl,space,sName));
        for(int a=0,c=x,f=y;a<space;a++)
        {
            if(pl.equals("v"))
            {
                if(x+space<=10){
                    if(gridP.board[c][y]=="~"){
                gridP.board[c][y]=e;
                c++;}
                else{
                        System.out.println("Can't place ship here New Coordinates: ");
                    g.remove(g.size()-1);
                    addPieces(type);
                    break;
                    }
                }

                else{
                    System.out.println("Can't place ship here New Coordinates: ");
                    g.remove(g.size()-1);
                    addPieces(type);
                break;}

            }
            else if(pl.equals("h"))
            {
                if(y+space<=10){
                    if(gridP.board[x][f]=="~"){
                        gridP.board[x][f]=e;
                        f++;}
                    else{
                        System.out.println("Can't place ship here New Coordinates: ");
                        g.remove(g.size()-1);
                        addPieces(type);
                        break;
                    }
                }
                else{
                    System.out.println("Can't place ship here New Coordinates: ");
                    g.remove(g.size()-1);
                    addPieces(type);
                    break;}
            }
        }

    }
    public void guessIt(Player opponent,String guess)
    {
        String[][] oBoard=opponent.gridP.board;

        int t=0;
        int x=0,y=0;

        for(char d:guess.toCharArray())
        {
            if(d!='('&&d!=')'&&d!=','&&Character.isDigit(d))
            {
                if(t==0)
                {
                    x=Integer.parseInt(String.valueOf(d));
                    t++;
                }
                else if(t==1)
                {
                    y=Integer.parseInt(String.valueOf(d));

                }
            }
        }
        if(oBoard[x][y]!="~")
        {
            switch (oBoard[x][y]){
                case "C":
                    c--;
                    if(c==0)
                    {
                        System.out.println("You have sunk the Carrier");

                    }
                    break;
                case "B":
                    b--;
                    if(b==0)
                    {
                        System.out.println("You have sunk the Battleship");
                    }
                    break;
                case "D":
                    d--;
                    if(d==0)
                    {
                        System.out.println("You have sunk the Destroyer");

                    }
                    break;
                case "S":
                    s--;
                    if(s==0)
                    {
                        System.out.println("You have sunk the Submarine");

                    }
                    break;
                case "P":
                    p--;
                    if(p==0)
                    {
                        System.out.println("You have sunk the Patrol Boat");

                    }

            }
            oBoard[x][y]="X";
        }
        else if(oBoard[x][y]=="X")
        {
            System.out.println("Already hit Choose again");
            guessIt(opponent, in.next());
        }
        else
        {
            System.out.println("Missed");
        }
        if (c==0&&b==0&&d==0&&s==0&&p==0)
        {
            System.out.println(name+" ,you have won");
            won=true;

        }
    }
}
