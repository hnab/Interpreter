/**
 * Filename: Turtle.java
 * Turtle class implements Turtle object and the following methods:
 *      - public methods:
 *          . void move(int distance)
 *          . void turn(int degrees)
 *          . float direction()
 *          . Point location()
 *          . float distanceTo(Point point)
 *          . float bearingTo(Point point)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Models;

public class Turtle {

    private Point currentLocation;
    private float direction;

    public Turtle(){
        this.currentLocation = new Point(0,0);
        this.direction = 0;
    }

    public void move(int distance){
        double radians = (direction * Math.PI) / 180;
        double deltaX = Math.cos(radians) * distance;
        double deltaY = Math.sin(radians) * distance;
        double newX = this.currentLocation.getX()+deltaX;
        double newY = this.currentLocation.getY()+deltaY;
        this.currentLocation.setX((int) Math.round(newX));
        this.currentLocation.setY((int) Math.round(newY));
        System.out.println(currentLocation.toString());
    }
    public void turn(int degrees){
        this.direction = (this.direction + degrees) % 360;

        if (this.direction < 0) {
            this.direction += 360;
        } else if (this.direction >= 360) {
            this.direction %= 360;
        }
        System.out.println("Direction:"+this.direction);

    }

    public float direction(){
        return this.direction;
    }

    public Point location(){
        return this.currentLocation;
    }

    public float distanceTo(Point point){

        int x_diff = currentLocation.getX()- point.getX();
        int y_diff = currentLocation.getY()- point.getY();

        return (float) Math.sqrt(Math.pow(x_diff, 2)+ Math.pow(y_diff, 2));
    }

    public float bearingTo(Point point){
        int x_diff = point.getX() - currentLocation.getX();
        int y_diff = point.getY() - currentLocation.getY();

        double angle = Math.atan2(y_diff, x_diff);

        float bearing = (float) Math.toDegrees(angle);

        bearing = (bearing + 360) % 360;

        return bearing;
    }

}
