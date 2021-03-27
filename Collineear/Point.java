import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void draw(){

        StdDraw.point(x,y);
    }
    public  void drawTo(Point that){

        StdDraw.line(x,y,that.x,that.y);
    }
    public  int compareTo(Point that) {     // compare two points by y-coordinates, breaking ties by x-coordinates
        if(y == that.y){
            if(x < that.x){
                return -1;
            } else if(x == that.x){
                return 0;
            } else {
                return 1;
            }
        } else if(y < that.y){
            return -1;
        } else {
            return 1;
        }
    }
    public  double slopeTo(Point that) {       // the slope between this point and that point
        if(x - that.x == 0){
            if(y - that.y == 0){
                return Double.NEGATIVE_INFINITY;
            } else {
                return Double.POSITIVE_INFINITY;
            }
        } else if(y == that.y){
            return 0.0;
        }
        double slope = (y - that.y)/(x - that.x);
        return slope;
    }
    public Comparator<Point> slopeOrder() {              // compare two points by slopes they make with this point
        Comparator<Point> slopCompare = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double slopo1 = slopeTo(o1);
                double slopo2 = slopeTo(o2);
                if (slopo1 < slopo2)
                    return -1;
                else if (slopo1 > slopo2)
                    return 1;
                else
                    return 0;
            }
        };
        return slopCompare;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
