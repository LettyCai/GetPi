import java.awt.*;

public class Circle {

    public Circle(int x,int y,int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    private int x;
    private int y;
    private int r;

    public int getX(){return x; }

    public int getY(){return y;}

    public int getR() {return r;}

    public boolean isContain(Point p){
        return Math.pow(p.x-x,2)+Math.pow(p.y-y,2)<=r*r;
    }
}
