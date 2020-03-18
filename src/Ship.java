public class Ship {
    int x;
    int y;
    String plane;
    int spaces;
    String shipName;
    public Ship(int x,int y,String plane,int spaces,String shipName)
    {
        this.x=x;
        this.y=y;
        this.plane=plane;
        this.spaces=spaces;
        this.shipName=shipName;


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPlane() {
        return plane;
    }

public void print()
{
    System.out.println(x);
    System.out.println(y);
    System.out.println(plane);
}
}
