import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player{
    Scanner in = new Scanner(System.in);
    String name;
    Grid gridP=new Grid();
    String [][] Board=new String[10][10];
    String typeOfShip;


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
            System.out.println("Enter the coordinates for the"+ gridP.nCarrier+": ");
        sName=gridP.nCarrier;
        space=gridP.Carrier;
        e="C";
        }
       else if(type.equals("BattleShip")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the"+ gridP.nBattleship+": ");
            sName=gridP.nBattleship;
            space=gridP.Battleship;
            e="B";
       }
        else if(type.equals("Destroyer")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the"+ gridP.nDestroyer+": ");
            sName=gridP.nDestroyer;
            space=gridP.Destroyer;
            e="D";

        }
        else if(type.equals("Submarine")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the"+ gridP.nSubmarine+": ");
            sName=gridP.nSubmarine;
            space=gridP.Submarine;
            e="S";
        }
        else if(type.equals("PatrolBoat")){
            System.out.println(name+" ,please enter the coordinates for your ships");
            System.out.println("Enter the coordinates for the"+ gridP.nPatrolBoat+": ");
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
             if(d!='('&&d!=')'&&d!=',')
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
        for(int a=0,c=x,f=y;a<=space;a++)
        {
            if(pl.equals("v"))
            {
                if(x+space<=9){
                gridP.board[c][y]=e;
                c++;}
                else{
                    System.out.println("Can't place ship here New Coordinates: ");
                    g.remove(g.size()-1);
                    addPieces(type);
                break;}

            }
            else if(pl.equals("h"))
            {
                if(y+space<=9){
                gridP.board[x][f]=e;
                f++;}
                else{
                    System.out.println("Can't place ship here New Coordinates: ");
                    g.remove(g.size()-1);
                    addPieces(type);
                    break;

                }
            }
        }

    }
}
