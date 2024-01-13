/**
 * Filename: Point.java
 * Turtle class implements Point object and the following methods:
 *      - public methods:
 *          . int getX()
 *          . int getY()
 *          . void setX(int x)
 *          . void setY(int y)
 *          . String toString()
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Models;

public class Point {
    private int x;
    private int y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
      return "("+getX()+","+getY()+")";
    }
}
